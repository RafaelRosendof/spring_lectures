package com.SistemLoja.SistemaLoja.Entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "Funcionario")

public class FuncionarioEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

    @Column(name = "login")
    private String login;

    @Column(name = "senha")
    private String senha;

    @Column(name = "cargo")
    private String cargo;

    public FuncionarioEntity(){}

    public FuncionarioEntity(int id ,String cargo, String nome , String cpf , String email  ,String login , String senha){
        this.id = id;
        this.cargo = cargo;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getCargo(){
        return cargo;
    }
    public void setCargo(String cargo){
        this.cargo = cargo;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCPF(){
        return cpf;
    }
    public void setCPF(String cpf){
        this.cpf = cpf;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
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








    //toString
    @Override
    public String toString(){
        return "USUÁRIO{ " +
        "id = " + id +
        ", Nome = "+ nome + '\''+
        ", cpf = " + cpf + '\'' +
        ", email = " + email + '\''+
        ", login = " + login + '\''+
        ", senha = " + senha + '\''+ 
        ", cargo = " + cargo + '\''+
        '}';
    }
}