package com.liza.hsimR_backend.service;

import java.security.Principal;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.liza.hsimR_backend.dto.TraceDto;
import com.liza.hsimR_backend.model.Etablissement;
import com.liza.hsimR_backend.model.Franchise;
import com.liza.hsimR_backend.model.TraceType;

public interface TraceService {

	void tracer(TraceType type, Principal principal, String description)
			throws EntityNotFoundException;

	void tracer(TraceType type, Franchise franchise, Etablissement etablissement, String description);

	List<TraceDto> getTraceNonFiltree(List<TraceType> types);

}