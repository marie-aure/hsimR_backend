package com.liza.hsimR_backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.liza.hsimR_backend.model.Franchise;
import com.liza.hsimR_backend.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

	List<Transaction> findAllBySourceF(Franchise franchise);

	List<Transaction> findAllByDestinataireF(Franchise franchise);

}
