package com.liza.hsimR_backend.service;

import java.security.Principal;

import javax.persistence.EntityNotFoundException;

import com.liza.hsimR_backend.dto.InfoPassageDto;
import com.liza.hsimR_backend.dto.TourDto;
import com.liza.hsimR_backend.model.Tour;

public interface TourService {

	TourDto getTourActif() throws EntityNotFoundException;

	TourDto convertToDto(Tour tour);

	InfoPassageDto infoPassage() throws EntityNotFoundException;

	void finTour(Principal principal) throws EntityNotFoundException;

}