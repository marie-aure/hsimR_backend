package com.liza.hsimR_backend.service;

import com.liza.hsimR_backend.dto.AuthentificationDto;
import com.liza.hsimR_backend.model.Franchise;

public interface LoginService {
	
	void creerFranchise(AuthentificationDto login) throws IllegalArgumentException;

	Franchise login(String nom, String password) throws IllegalArgumentException;

}
