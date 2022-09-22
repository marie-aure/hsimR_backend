package com.liza.hsimR_backend.web;

import java.security.Principal;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.liza.hsimR_backend.dto.TransactionDto;
import com.liza.hsimR_backend.model.exception.InsufficientResourceException;
import com.liza.hsimR_backend.service.BanqueService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/banque")
public class BanqueController {

	@Autowired
	private BanqueService banqueService;

	@PostMapping("/depense")
	public TransactionDto creerDepense(Principal principal, @RequestBody TransactionDto transactionDto) {

		try {
			return banqueService.creerDepense(principal, transactionDto);
		} catch (EntityNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		} catch (IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		} catch (InsufficientResourceException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

}
