package com.liza.hsimR_backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.liza.hsimR_backend.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {



}
