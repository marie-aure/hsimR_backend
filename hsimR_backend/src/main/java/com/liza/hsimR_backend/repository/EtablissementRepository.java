package com.liza.hsimR_backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.liza.hsimR_backend.model.Etablissement;
import com.liza.hsimR_backend.model.Franchise;

public interface EtablissementRepository extends CrudRepository<Etablissement, Long> {

	List<Etablissement> findByFranchise(Franchise franchise);

}
