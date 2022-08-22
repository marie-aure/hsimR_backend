package com.liza.hsimR_backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class HsimRBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HsimRBackendApplication.class, args);
	}

	@Override
	public void run(String... args) {

		// Launch method
		System.out.println("Sandbox - started");

	}

}
