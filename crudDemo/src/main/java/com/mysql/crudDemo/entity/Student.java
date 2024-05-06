package com.mysql.crudDemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student{
    /*
     * definiir campos 
     * construtores
     * get e sets
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    public Student(){} //depois de algumas horas deu bom kkkkkk, se lembre de colocar o oconstrutor default 

    //construtores
    public Student(String firstName , String lastName , String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //gets e setes figas

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getFirsName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getlastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    } 

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    //definindo o metodo to string com os métodos
    @Override
    public String toString(){
        return "Student{" +
        "id=" + id +
        ", primeiro nome= "+ firstName + '\''+
        ", sobrenome= '" + lastName + '\''+
        ", email='" + email + '\''+
        '}';

    }
}