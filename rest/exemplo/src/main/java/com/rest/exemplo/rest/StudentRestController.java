package com.rest.exemplo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.exemplo.entity.Student;

import jakarta.annotation.PostConstruct;


@RestController
@RequestMapping("/api")
public class StudentRestController {

   private List<Student> theStudents; 


   @PostConstruct
   public void loadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Rofigo", "Cleiton"));
        theStudents.add(new Student("Rafael", "Rossi"));
        theStudents.add(new Student("Rafael", "Del Piero"));
   }

   @GetMapping("/students")
  public List<Student> getStudents(){
    return theStudents;
  } 

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        // just index into the list ... keep it simple for now

        if (( studentId >= theStudents.size()) || (studentId < 0)){
            throw new StudentNotFoundException("Não achou o estudante: " + studentId);
        }
        return theStudents.get(studentId);
    }



}

