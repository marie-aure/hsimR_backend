package com.liza.hsimR_backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.liza.hsimR_backend.model.Franchise;

public interface FranchiseRepository extends CrudRepository<Franchise, Long> {

	Optional<Franchise> findByNom(String nom);

	List<Franchise> findAllByNomNot(String nom);

	List<Franchise> findAll();

}
