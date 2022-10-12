package com.liza.hsimR_backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.liza.hsimR_backend.dto.AuthentificationDto;
import com.liza.hsimR_backend.model.Franchise;
import com.liza.hsimR_backend.model.TraceType;
import com.liza.hsimR_backend.repository.FranchiseRepository;
import com.liza.hsimR_backend.service.LoginService;
import com.liza.hsimR_backend.service.TraceService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private FranchiseRepository franchiseRepository;

	@Autowired
	private TraceService traceService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void creerFranchise(AuthentificationDto login) throws IllegalArgumentException {

		if (franchiseRepository.findByNom(login.getNom()).isPresent()) {
			throw new IllegalArgumentException("Franchise already exists");
		}

		Franchise franchise;
		franchise = new Franchise(login.getNom(), passwordEncoder.encode(login.getPassword()), "ROLE_USER", 10000,2,1);
		
		franchiseRepository.save(franchise);
		
		traceService.tracer(TraceType.CREATION_FRANCHISE, franchise,
				new StringBuilder("Creation de la franchise ").append(login.getNom()).toString());
	}

	@Override
	public Franchise login(String nom, String password) throws IllegalArgumentException {
		Franchise franchise = franchiseRepository.findByNom(nom)
				.orElseThrow(() -> new IllegalArgumentException("Authentication incorrect"));

		if (passwordEncoder.matches(password, franchise.getPassword())) {
			return franchise;
		} else {
			throw new IllegalArgumentException("Authentication incorrect");
		}

	}

}

