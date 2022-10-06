package com.liza.hsimR_backend.web;

import java.security.Principal;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.liza.hsimR_backend.dto.FranchiseDto;
import com.liza.hsimR_backend.service.FranchiseService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/franchise")
public class FranchiseController {

	@Autowired
	private FranchiseService franchiseService;


	@GetMapping("/getInfo")
	@ResponseBody
	public FranchiseDto getFranchiseInfo(Principal principal) {

		try {
			return franchiseService.getUserFranchise(principal.getName());
		} catch (EntityNotFoundException | NullPointerException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

	@GetMapping("/destinataire")
	@ResponseBody
	public List<FranchiseDto> getTransactionDestinataire(Principal principal) {

		return franchiseService.getTransactionDestinataire(principal);
	}

}
