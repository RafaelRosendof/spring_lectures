package com.Rafael.exemplo_spring;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//código para colocar paths e printar coisas na tela, aos poucos vamos avançando nisso 



@SpringBootApplication
@RestController
public class ExemploSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExemploSpringApplication.class, args);
	}

	@GetMapping("/figas")
	//public String greet(){

	public GreetResponding greet(){     // 	com isso eu consigo enviar a base de json format
		//return "FALA FIGAS!";

		GreetResponding response = new GreetResponding("Fala_figas", List.of("Java" , "Go" ,"c++", "python") ,new Person("Rafael", 19,1.78));

		return response;
	}

	record Person(String name , int age , double altura){}
	record GreetResponding(
		String greet, List<String> programming_langs, Person person){}

	/* 
	class GreetResponding{
		private final String greet;

		GreetResponding(String greet){
			this.greet = greet;
		}

		public String getGreet(){ return greet; }

		@Override
		public String toString(){
			return "GreetResponsing{" + "greet='" + greet + '\'' + '}';
		}
		@Override
		public boolean equals(Object o) {
			if(this == o ) return true;
			
			if(o == null || getClass() != o.getClass()) return false;

			GreetResponding that = (GreetResponding) o;

			return Objects.equals(greet, that.greet);
		}

		@Override
		public int hashCode(){
			return Objects.hash(greet);
		}
	}
*/
}
