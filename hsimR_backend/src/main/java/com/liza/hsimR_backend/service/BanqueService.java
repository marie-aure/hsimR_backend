package com.liza.hsimR_backend.service;

import java.security.Principal;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.liza.hsimR_backend.dto.TransactionDto;
import com.liza.hsimR_backend.model.exception.InsufficientResourceException;

public interface BanqueService {

	TransactionDto creerDepense(Principal principal, TransactionDto transactionDto)
			throws EntityNotFoundException, IllegalArgumentException, InsufficientResourceException;

	List<TransactionDto> historiqueTransaction(Principal principal, String type);

}