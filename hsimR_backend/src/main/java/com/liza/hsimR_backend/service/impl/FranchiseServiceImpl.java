package com.liza.hsimR_backend.service.impl;

import java.util.Objects;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
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
	public FranchiseDto getUserFranchise(String name) throws EntityNotFoundException, NullPointerException{
		Objects.requireNonNull(name);
		Franchise franchise = franchiseRepository.findByNom(name)
				.orElseThrow(() -> new EntityNotFoundException("Franchise " + name + " non trouvée en base"));
		return mapper.map(franchise, FranchiseDto.class);
	}

}
