package com.liza.hsimR_backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.liza.hsimR_backend.dto.AuthentificationDto;
import com.liza.hsimR_backend.model.Franchise;
import com.liza.hsimR_backend.repository.FranchiseRepository;
import com.liza.hsimR_backend.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private FranchiseRepository franchiseRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void creerFranchise(AuthentificationDto login) throws IllegalArgumentException {

		if (franchiseRepository.findByNom(login.getNom()).isPresent()) {
			throw new IllegalArgumentException("Franchise already exists");
		}

		Franchise franchise;
		franchise = new Franchise(login.getNom(), passwordEncoder.encode(login.getPassword()), "ROLE_USER");
		franchiseRepository.save(franchise);

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

