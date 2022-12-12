package com.liza.hsimR_backend.service.impl;

import java.security.Principal;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.liza.hsimR_backend.dto.InfoPassageDto;
import com.liza.hsimR_backend.dto.TourDto;
import com.liza.hsimR_backend.model.Franchise;
import com.liza.hsimR_backend.model.Tour;
import com.liza.hsimR_backend.model.modelEnum.TraceType;
import com.liza.hsimR_backend.repository.FranchiseRepository;
import com.liza.hsimR_backend.repository.TourRepository;
import com.liza.hsimR_backend.service.TourService;
import com.liza.hsimR_backend.service.TraceService;


@Service
public class TourServiceImpl implements TourService {

	@Autowired
	private TourRepository tourRepository;

	@Autowired
	private TraceService traceService;

	@Autowired
	private FranchiseRepository franchiseRepository;

	@Override
	public TourDto getTourActif() throws EntityNotFoundException {

		Tour tourActif = tourRepository.findByActif(true)
				.orElseThrow(() -> new EntityNotFoundException("Aucun tour actif"));
		return convertToDto(tourActif);

	}

	@Override
	public TourDto convertToDto(Tour tour) {
		return new TourDto(tour.getAnnee(),
				StringUtils.capitalize(tour.getMois().getDisplayName(TextStyle.FULL, Locale.FRANCE)),
				tour.getMois().getValue(), tour.getSemaineMois(),
				tour.getCle());
	}

	public InfoPassageDto infoPassage() throws EntityNotFoundException {

		Tour tourActif = tourRepository.findByActif(true)
				.orElseThrow(() -> new EntityNotFoundException("Aucun tour actif"));
		Tour tourSuivant = tourRepository.findByCle(tourActif.getCle() + 1)
				.orElseThrow(() -> new EntityNotFoundException("Aucun tour suivant"));

		return new InfoPassageDto(tourActif.getAnnee() != tourSuivant.getAnnee(),
				tourActif.getMois() != tourSuivant.getMois(), convertToDto(tourSuivant));
		 
	}

	@Override
	public void finTour(Principal principal) throws EntityNotFoundException {
		// vérification et actions
		// rien pour l'instant

		Tour tourActif = tourRepository.findByActif(true)
				.orElseThrow(() -> new EntityNotFoundException("Aucun tour actif"));
		Tour tourSuivant = tourRepository.findByCle(tourActif.getCle() + 1)
				.orElseThrow(() -> new EntityNotFoundException("Aucun tour suivant"));

		if (tourActif.getAnnee() != tourSuivant.getAnnee()) {
			System.out.println("Changement d'année");
			// Générer pour chaque franchise 1 token ch + 1 token cheval par établissement
			List<Franchise> franchises = franchiseRepository.findAll();
			franchises.stream().forEach(franchise -> {
				franchise.setTokenCheval(franchise.getTokenCheval() + 1 + franchise.getLEtablissements().size());
				franchiseRepository.save(franchise);
			});
		}
		if (tourActif.getMois() != tourSuivant.getMois()) {
			System.out.println("Changement de mois");
			// Rien pour l'instant
		}

		// passage au tour suivant
		tourSuivant.setActif(true);
		tourActif.setActif(false);

		tourRepository.saveAll(Arrays.asList(tourActif, tourSuivant));

		traceService.tracer(TraceType.FIN_TOUR, principal,
				new StringBuilder("Le tour ").append(tourActif.getCle()).append(" a été clôturé").toString());

		// générer les tours suivants :
		// calcul de la clé = = année*48+(mois-1)*4+semaine
		// calcul de la date depuis la clé :
		// année = ROUNDDOWN(année/48;0)
		// mois = ROUNDDOWN((clé-année*48)/4;0)+1
		// semaine = clé-année*48-(mois-1)*4

	}

}
