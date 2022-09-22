package com.liza.hsimR_backend.service.impl;

import java.lang.reflect.Type;
import java.security.Principal;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liza.hsimR_backend.dto.FranchiseDto;
import com.liza.hsimR_backend.model.Franchise;
import com.liza.hsimR_backend.repository.FranchiseRepository;
import com.liza.hsimR_backend.service.FranchiseService;

@Service
public class FranchiseServiceImpl implements FranchiseService {

	@Autowired
	private FranchiseRepository franchiseRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public FranchiseDto getUserFranchise(String name) throws EntityNotFoundException, NullPointerException {
		Objects.requireNonNull(name);
		Franchise franchise = franchiseRepository.findByNom(name)
				.orElseThrow(() -> new EntityNotFoundException("Franchise " + name + " non trouvée en base"));
		return mapper.map(franchise, FranchiseDto.class);
	}

	@Override
	public List<FranchiseDto> getTransactionDestinataire(Principal principal) {
		List<Franchise> franchises = franchiseRepository.findAllByNomNot(principal.getName());
		// Mapping to DTO
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		Type listType = new TypeToken<List<FranchiseDto>>() {
		}.getType();

		return mapper.map(franchises, listType);
	}

}
