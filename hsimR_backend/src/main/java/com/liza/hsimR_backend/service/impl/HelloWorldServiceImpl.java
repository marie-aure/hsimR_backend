package com.liza.hsimR_backend.service.impl;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liza.hsimR_backend.model.Hello;
import com.liza.hsimR_backend.repository.HelloRepository;
import com.liza.hsimR_backend.service.HelloWorldService;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

	@Autowired
	private HelloRepository helloRepository;

	@Override
	public Hello getHelloMessage() {
		return helloRepository.findById(1).orElseThrow(() -> new EntityNotFoundException("Hello was not found"));
	}

}
