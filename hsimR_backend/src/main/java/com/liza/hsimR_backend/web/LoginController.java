package com.liza.hsimR_backend.web;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

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
import com.liza.hsimR_backend.dto.FranchiseDto;
import com.liza.hsimR_backend.model.Franchise;
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
		} catch (IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

	@PostMapping("/connexion")
	@ResponseBody
	public FranchiseDto connexion(@RequestBody String login) {
		try {
			byte[] base64Token = login.getBytes(StandardCharsets.UTF_8);
			String decoded = new String(Base64.getDecoder().decode(base64Token));
			String[] split = decoded.split(":");

			if (split.length != 2) {
				throw new IllegalArgumentException("Invalid basic authentication token");
			}

			Franchise franchise = loginService.login(split[0], split[1]);

			return new FranchiseDto(franchise.getNom());

		} catch (IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}
}
