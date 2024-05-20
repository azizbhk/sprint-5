package com.aziz.voyages;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.aziz.voyages.entities.Type;
import com.aziz.voyages.entities.Voyage;



@SpringBootApplication
public class VoyageApplication implements CommandLineRunner {

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(VoyageApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Voyage.class,Type.class);
		

	}
	

}
