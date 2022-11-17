package com.liza.hsimR_backend.service;

import java.security.Principal;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.liza.hsimR_backend.dto.EtablissementDto;
import com.liza.hsimR_backend.dto.TypeEtablissementDto;
import com.liza.hsimR_backend.model.exception.InsufficientResourceException;

public interface EtablissementService {

	List<TypeEtablissementDto> getTypes();

	void creerEtablissement(EtablissementDto etablissementDto, boolean token, Principal principal)
			throws EntityNotFoundException, IllegalArgumentException, InsufficientResourceException;

	List<EtablissementDto> getListeEtablissement(Principal principal) throws EntityNotFoundException;

}