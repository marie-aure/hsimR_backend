package com.liza.hsimR_backend.service.impl;

import java.lang.reflect.Type;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import com.liza.hsimR_backend.dto.EtablissementDto;
import com.liza.hsimR_backend.dto.TypeEtablissementDto;
import com.liza.hsimR_backend.model.Etablissement;
import com.liza.hsimR_backend.model.Franchise;
import com.liza.hsimR_backend.model.exception.InsufficientResourceException;
import com.liza.hsimR_backend.model.modelEnum.TraceType;
import com.liza.hsimR_backend.model.modelEnum.TypeEtablissement;
import com.liza.hsimR_backend.repository.EtablissementRepository;
import com.liza.hsimR_backend.repository.FranchiseRepository;
import com.liza.hsimR_backend.service.BanqueService;
import com.liza.hsimR_backend.service.EtablissementService;
import com.liza.hsimR_backend.service.TraceService;

@Service
public class EtablissementServiceImpl implements EtablissementService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private EtablissementRepository etablissementRepository;

	@Autowired
	private FranchiseRepository franchiseRepository;

	@Autowired
	private TraceService traceService;

	@Autowired
	private BanqueService banqueService;

	@Override
	public List<TypeEtablissementDto> getTypes() {
		List<TypeEtablissement> types = Arrays.asList(TypeEtablissement.values());

		// Mapping to DTO
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		Type listType = new TypeToken<List<TypeEtablissementDto>>() {
		}.getType();

		return mapper.map(types, listType);
	}

	@Override
	public void creerEtablissement(EtablissementDto etablissementDto, boolean token, Principal principal)
			throws EntityNotFoundException, IllegalArgumentException, InsufficientResourceException {

		Franchise franchise = franchiseRepository.findByNom(principal.getName()).orElseThrow(
				() -> new EntityNotFoundException("la franchise connectée n'a pas été trouvée en base de données"));

		try {
			Etablissement etablissement = new Etablissement(etablissementDto.getNom(),
					TypeEtablissement.valueOf(etablissementDto.getType().getType()), franchise);

			if (token) {
				if (franchise.getTokenEtablissement() > 0) {
					franchise.setTokenEtablissement(franchise.getTokenEtablissement() - 1);
				} else {
					throw new InsufficientResourceException("Pas de token établissement disponible");
				}
			} else {
				if (franchise.getArgent() >= 100000) {
					franchise.setArgent(franchise.getArgent() - 100000);
					String libelleTransaction = new StringBuilder("Création de l'établissement ")
							.append(etablissement.getNom()).toString();
					banqueService.creerDepense(100000, libelleTransaction, franchise, null);
				}else {
					throw new InsufficientResourceException("Pas assez d'argent pour créer l'établissement");
				}
			}
			etablissementRepository.save(etablissement);
			franchiseRepository.save(franchise);
			traceService.tracer(TraceType.CREATION_ETABLISSEMENT, franchise, etablissement,
					new StringBuilder("L'établissement ").append(etablissement.getNom())
							.append(token ? " a été créé contre 1 token établissement" : " a été créé contre 100 000$")
							.toString());

		} catch (IllegalArgumentException e) {
			System.out.println("Error lors de la creation de l'établissement");
			throw new IllegalArgumentException("Impossible de reconnaître le type d'établissement");
		}

	}

	@Override
	public List<EtablissementDto> getListeEtablissement(Principal principal) throws EntityNotFoundException {
		Franchise franchise = franchiseRepository.findByNom(principal.getName()).orElseThrow(
				() -> new EntityNotFoundException("la franchise connectée n'a pas été trouvée en base de données"));

		List<Etablissement> etablissements = etablissementRepository.findByFranchise(franchise);

		// Mapping to DTO
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		Type listType = new TypeToken<List<EtablissementDto>>() {
		}.getType();

		return mapper.map(etablissements, listType);
	}

	@Override
	public EtablissementDto getEtablissement(Principal principal, long id)
			throws EntityNotFoundException, AccessDeniedException {
		Franchise franchise = franchiseRepository.findByNom(principal.getName()).orElseThrow(() -> new EntityNotFoundException("la franchise connectée n'a pas été trouvée en base de données"));
		
		Etablissement etablissement = etablissementRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("l'établissement demandé n'a pas été trouvé en base de données"));
		if (!franchise.equals(etablissement.getFranchise())) {
			throw new AccessDeniedException("la franchise connectée n'a pas accès à cet établissement");
		} else {
			return mapper.map(etablissement, EtablissementDto.class);
		}
	}

}
