package com.trabalho.pix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Scanner;

import com.trabalho.pix.view.AutenticaView;


@SpringBootApplication
public class PixApplication {

	public static void main(String[] args) {
		SpringApplication.run(PixApplication.class, args);

	}

	Scanner leitor = new Scanner(System.in);
	@Bean
	public CommandLineRunner commandLineRunner(@Autowired AutenticaView autenticaView){

		return runner ->{
			autenticaView.menuPrincipal();
		};
	}

}
