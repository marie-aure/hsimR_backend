package com.liza.hsimR_backend.service.impl;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liza.hsimR_backend.dto.AuthentificationDto;
import com.liza.hsimR_backend.model.Franchise;
import com.liza.hsimR_backend.repository.FranchiseRepository;
import com.liza.hsimR_backend.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private FranchiseRepository franchiseRepository;

	@Override
	public void creerFranchise(AuthentificationDto login) throws NoSuchAlgorithmException, InvalidKeySpecException {

		String salt = getSalt().toString();
		Franchise franchise;
		franchise = new Franchise(login.getNom(), genererPasswordSecurise(login.getPassword(), salt),
				salt);
		franchiseRepository.save(franchise);
	}

	@Override
	public byte[] getSalt() {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		return salt;
	}

	private byte[] hash(char[] password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
		KeySpec spec = new PBEKeySpec(password, salt, 65536, 128);
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		return factory.generateSecret(spec).getEncoded();
	}

	@Override
	public String genererPasswordSecurise(String password, String salt)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		byte[] passwordBA = hash(password.toCharArray(), salt.getBytes());
		return Base64.getEncoder().encodeToString(passwordBA);
	}

}

