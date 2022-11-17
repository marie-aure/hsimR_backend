package com.liza.hsimR_backend.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.liza.hsimR_backend.dto.TraceDto;
import com.liza.hsimR_backend.modelEnum.TraceType;
import com.liza.hsimR_backend.service.TraceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/trace")
public class TraceController {

	@Autowired
	private TraceService traceService;

	@PostMapping("/admin/get")
	@ResponseBody
	public List<TraceDto> traceNonFiltre(@RequestBody List<TraceType> lTypes) {

		return traceService.getTraceNonFiltree(Arrays.asList(TraceType.FIN_TOUR));

	}

}
