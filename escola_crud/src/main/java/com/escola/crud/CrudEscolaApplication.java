package com.escola.crud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudEscolaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudEscolaApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(){
		return runner -> {
			System.out.println("FALA FIGAS");
		};
	}
  

}
