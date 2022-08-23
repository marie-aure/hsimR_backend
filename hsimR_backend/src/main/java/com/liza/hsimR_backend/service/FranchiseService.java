package com.liza.hsimR_backend.service;

import javax.persistence.EntityNotFoundException;

import com.liza.hsimR_backend.dto.FranchiseDto;

public interface FranchiseService {

	FranchiseDto getUserFranchise(String name) throws EntityNotFoundException, NullPointerException;

}