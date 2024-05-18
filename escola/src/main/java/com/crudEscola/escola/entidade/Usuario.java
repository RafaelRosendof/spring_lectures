package com.crudEscola.escola.entidade;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class Usuario{
    /*
     * definir campos
     * construtores
     * get e sets
     */

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private int id;

     @Column(name="typeOfUser")
     private String typeOfUser;

     @Column(name="primeiroNome")
     private String primeiroNome;

     @Column(name="sobrenome")
     private String sobrenome;

     @Column(name="email")
     private String email;

     public Usuario(){
      
     } //construtor default necessário 

     public Usuario(String typeOfUser , String primeiroNome , String sobrenome, String email){
        this.typeOfUser = typeOfUser;
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.email = email;
     }

     //gets and sets
     public int getId(){
        return id;
     }
     public void setId(int id){
        this.id = id;
     }


     public String getTypeOfUser(){
        return typeOfUser;
     }
     public void setTypeOfUser (String typeOfUser){
        this.typeOfUser = typeOfUser;
     }


     public String getPrimeiroNome(){
        return primeiroNome;
     }
     public void setPrimeiroNome (String primeiroNome){
        this.primeiroNome = primeiroNome;
     }


     public String getSobrenome(){
        return sobrenome;
     }
     public void setSobrenome (String sobrenome){
        this.sobrenome = sobrenome;
     }


     public String getEmail(){
        return email;
     }
     public void setEmail (String email){
        this.email = email;
     }

     //definindo o método to String com os métodos
     @Override
     public String toString(){
        return "USUÁRIO{ " +
        "id = " + id +
        ", tipo_de_usuário = "+ typeOfUser + '\''+
        ", primeiroNome = " + primeiroNome + '\'' +
        ", sobrenome= " + sobrenome + '\''+
        ", email = " + email + '\''+ 
        
        '}';
     }
}