package com.liza.hsimR_backend.web;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liza.hsimR_backend.dto.InfoPassageDto;
import com.liza.hsimR_backend.dto.TourDto;
import com.liza.hsimR_backend.service.TourService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/tour")
public class TourController {

	@Autowired
	private TourService tourService;

	@Autowired
	private ObjectMapper mapper;

	@GetMapping("/actif")
	@ResponseBody
	public TourDto tourActif() {

		try {
			TourDto tourActif = tourService.getTourActif();
			return tourActif;
		} catch (EntityNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}

	}

	@GetMapping("/infoPassage")
	@ResponseBody
	public InfoPassageDto infoPassage() {

		try {
			return tourService.infoPassage();
		} catch (EntityNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}

	}

}
