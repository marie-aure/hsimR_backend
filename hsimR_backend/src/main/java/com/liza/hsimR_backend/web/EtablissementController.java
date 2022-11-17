package com.liza.hsimR_backend.web;

import java.security.Principal;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.liza.hsimR_backend.dto.EtablissementDto;
import com.liza.hsimR_backend.dto.TypeEtablissementDto;
import com.liza.hsimR_backend.model.exception.InsufficientResourceException;
import com.liza.hsimR_backend.service.EtablissementService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/etablissement")
public class EtablissementController {

	@Autowired
	private EtablissementService etablissementService;

	@GetMapping("/types")
	public List<TypeEtablissementDto> getTypesEtablissement() {

		return etablissementService.getTypes();

	}

	@PostMapping("/creer/{token}")
	@ResponseBody
	public void creerEtablissement(@RequestBody EtablissementDto etablissementDto, @PathVariable("token") boolean token,
			Principal principal) {

		try {
			Objects.requireNonNull(etablissementDto);
			etablissementService.creerEtablissement(etablissementDto, token, principal);
		} catch (NullPointerException | IllegalArgumentException | EntityNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		} catch (InsufficientResourceException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

	@GetMapping("/liste")
	@ResponseBody
	public List<EtablissementDto> getListeEtablissement(Principal principal) {

		try {
			return etablissementService.getListeEtablissement(principal);
		} catch (EntityNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

}
