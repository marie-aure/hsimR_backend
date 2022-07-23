package com.liza.hsimR_backend.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.liza.hsimR_backend.model.Tour;

public interface TourRepository extends CrudRepository<Tour, Long> {

	Optional<Tour> findByActif(boolean actif);

}
