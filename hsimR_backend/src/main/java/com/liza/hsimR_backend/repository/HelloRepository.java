package com.liza.hsimR_backend.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.liza.hsimR_backend.model.Hello;

public interface HelloRepository extends CrudRepository<Hello, Long> {

	Optional<Hello> findById(long id);

}
