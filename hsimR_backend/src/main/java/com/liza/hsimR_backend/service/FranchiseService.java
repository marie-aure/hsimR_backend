package com.liza.hsimR_backend.service;

import java.security.Principal;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.liza.hsimR_backend.dto.FranchiseDto;

public interface FranchiseService {

	FranchiseDto getUserFranchise(String name) throws EntityNotFoundException, NullPointerException;

	List<FranchiseDto> getTransactionDestinataire(Principal principal);

}