package com.liza.hsimR_backend.service.impl;

import java.lang.reflect.Type;
import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liza.hsimR_backend.dto.TraceDto;
import com.liza.hsimR_backend.model.Etablissement;
import com.liza.hsimR_backend.model.Franchise;
import com.liza.hsimR_backend.model.Trace;
import com.liza.hsimR_backend.modelEnum.TraceType;
import com.liza.hsimR_backend.repository.FranchiseRepository;
import com.liza.hsimR_backend.repository.TraceRepository;
import com.liza.hsimR_backend.service.TraceService;


@Service
public class TraceServiceImpl implements TraceService {

	@Autowired
	private TraceRepository traceRepository;

	@Autowired
	private FranchiseRepository franchiseRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public void tracer(TraceType type, Principal principal, String description) throws EntityNotFoundException {

		Franchise franchise = franchiseRepository.findByNom(principal.getName())
				.orElseThrow(() -> new EntityNotFoundException("Logged in user not found in database"));

		tracer(type, franchise, null, description);
	}

	@Override
	public void tracer(TraceType type, Franchise franchise, Etablissement etablissement, String description) {

		Trace trace = new Trace(type, description, new Date(), franchise, etablissement);
		traceRepository.save(trace);

	}

	@Override
	public List<TraceDto> getTraceNonFiltree(List<TraceType> types) {

		List<Trace> traces = traceRepository.findByTypeInOrderByDateDesc(types);

		// Mapping to DTO
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		Type listType = new TypeToken<List<TraceDto>>() {
		}.getType();

		return mapper.map(traces, listType);
	}


}
