package com.liza.hsimR_backend.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.liza.hsimR_backend.service.HelloWorldService;

@RestController
@RequestMapping("/api/hello")
@CrossOrigin(origins = "http://localhost:4200")
public class HelloWorldController {

	@Autowired
	private HelloWorldService service;

	@GetMapping("/get")
	@ResponseBody
	public List<String> hello() {
		return Arrays.asList(service.getHelloMessage().getMessage());
	}

}
