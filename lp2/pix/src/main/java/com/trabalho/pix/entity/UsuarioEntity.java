package com.trabalho.pix.entity;

import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
//Classe abstrata entity id
public abstract class UsuarioEntity {
   /*
   definir campos
   construtor
   get e sets 
   */ 

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private int id;

   @Column(name="Nome")
   private String nome;

   @Column(name="Sobrenome")
   private String sobrenome;

   @Column(name="Login")
   private String login;

   @Column(name="Senha")
   private String senha;

   public UsuarioEntity(){}

   public UsuarioEntity(String nome , String sobrenome , String login , String senha){
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.login = login;
    this.senha = senha;
   }

   public int getId(){
    return id;
   }

   public void setId(int id){
    this.id = id;
   }

   public String getNome(){
    return nome;
   }
   public void setNome(String nome){
    this.nome = nome;
   }

   public String getSobrenome(){
    return sobrenome;
   }

   public void setSobrenome(String sobrenome){
    this.sobrenome = sobrenome;
   }

   public String getLogin(){
    return login;
   }
   public void setLogin(String login){
    this.login = login;
   }

   public String getSenha(){
    return senha;
   }
   public void setSenha(String senha){
    this.senha = senha;
   }

     //definindo o método to String com os métodos
     @Override
     public String toString(){
        return "USUÁRIO{ " +
        "id = " + id +
        ", tipo_de_usuário = "+ nome + '\''+
        ", primeiroNome = " + sobrenome + '\'' +
        ", sobrenome= " + login + '\''+
        ", senha = " + senha + '\''+ 
        
        '}';
     }

}
