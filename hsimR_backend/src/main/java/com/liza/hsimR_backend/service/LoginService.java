package com.liza.hsimR_backend.service;

import com.liza.hsimR_backend.dto.AuthentificationDto;

public interface LoginService {
	
	void creerFranchise(AuthentificationDto login) throws IllegalArgumentException;

}
