package com.mysql.crudDemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mysql.crudDemo.dao.StudentDAO;
import com.mysql.crudDemo.entity.Student;
import java.util.Scanner;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);

	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryStudent(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//delete(studentDAO);

		};
	}

	private void readStudent(StudentDAO studentDAO){
		System.out.println("Criando o objeto aluno ");
		Student temporatio = new Student("temp", "figas", "regiFigas@com.com");

		System.out.println("Slavando o aluno ");
		studentDAO.save(temporatio);

		int theId = temporatio.getId();
		System.out.println("Achou a id " + theId);

		Student myStudent = studentDAO.findById(theId);
		//return studentDAO;
		//printando 
		System.out.println("Aluno = " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO){
		System.out.println("Criando alguns estudantes a mais: ");
		Student tempStudent = new Student("Rafael", "Rosendo", "jarbascriminoso@gmail.com");
		Student tempStudent1 = new Student("Cabeçodov", "CabeçaMan", "figas@gfigas.com");
		Student tempStudent2 = new Student("Caioba", "Reginaldo", "figasclay@gmail.com");
		Student tempStudent3 = new Student("Hemet", "tetola", "figas@rofigo.com");

		System.out.println("Salvando os estudantes");

		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO){
		// create the student object
		System.out.println("Criando o estudante ");
		Student tempStudent = new Student("Paul", "Doe", "figas@gmail.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
	//criando o objeto estudante 
	//salvando e mostrando o id

	private void queryStudent(StudentDAO studentDAO){
		List<Student> theStudent = studentDAO.findAll();

		for(Student tempStudent : theStudent){
			System.out.println(tempStudent);
		}
	}


	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Figas");

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void updateStudent(StudentDAO studentDAO){
		//achar o id do aluno
		//mudar o nome dele 
		//atualizar e mostrar
		int studentID = 1;
		System.out.println("Pegando o aluno pelo id" + studentID);
		Student myStudent = studentDAO.findById(studentID);

		myStudent.setFirstName("EDINALDO");
		studentDAO.update(myStudent);

		System.out.println("Atualizado ");
	}

	private void delete(StudentDAO studentDAO){
		Scanner leitor = new Scanner(System.in);
		int studentId;
		System.out.println("Digite o número do estudante que precisa ser removido: "); //bem simples de ser resolvido 
		studentId = leitor.nextInt();

		studentDAO.delete(studentId);

		leitor.close();
	}

	//caso precise deletar tudo tem uma função na implementação de StudentDAOImpl.java só fazer aqui 
	/*
	 * private void deleteAllStudents(StudentDAo studentDAO){
	 * 		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	 * }
	 */

}
