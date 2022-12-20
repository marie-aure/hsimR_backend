package com.liza.hsimR_backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.liza.hsimR_backend.model.Trace;
import com.liza.hsimR_backend.model.modelEnum.TraceType;

public interface TraceRepository extends CrudRepository<Trace, Long> {

	List<Trace> findByTypeInOrderByDateDesc(List<TraceType> type);

}
