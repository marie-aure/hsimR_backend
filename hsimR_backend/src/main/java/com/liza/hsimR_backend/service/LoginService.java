package com.liza.hsimR_backend.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import com.liza.hsimR_backend.dto.AuthentificationDto;

public interface LoginService {
	
	void creerFranchise(AuthentificationDto login) throws NoSuchAlgorithmException, InvalidKeySpecException;

	byte[] getSalt();
	
	String genererPasswordSecurise(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException;

}
