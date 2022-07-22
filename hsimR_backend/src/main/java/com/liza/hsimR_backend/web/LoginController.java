package com.liza.hsimR_backend.web;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.liza.hsimR_backend.dto.AuthentificationDto;
import com.liza.hsimR_backend.service.LoginService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/creer")
	@ResponseBody
	public void creerFranchise(@RequestBody AuthentificationDto login) {

		try {
			loginService.creerFranchise(login);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Erreur technique lors de la création de la franchise");
		}

	}
}