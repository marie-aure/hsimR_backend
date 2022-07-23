package com.liza.hsimR_backend.service.impl;

import java.time.format.TextStyle;
import java.util.Locale;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.liza.hsimR_backend.dto.TourDto;
import com.liza.hsimR_backend.model.Tour;
import com.liza.hsimR_backend.repository.TourRepository;
import com.liza.hsimR_backend.service.TourService;


@Service
public class TourServiceImpl implements TourService {

	@Autowired
	private TourRepository tourRepository;

	@Override
	public TourDto getTourActif() throws EntityNotFoundException {

		Tour tourActif = tourRepository.findByActif(true)
				.orElseThrow(() -> new EntityNotFoundException("Aucun tour actif"));
		return convertToDto(tourActif);

	}

	@Override
	public TourDto convertToDto(Tour tour) {
		return new TourDto(tour.getAnnee(),
				StringUtils.capitalize(tour.getMois().getDisplayName(TextStyle.FULL, Locale.FRANCE)),
				tour.getMois().getValue(), tour.getSemaineMois(),
				tour.getCle());
	}

}
