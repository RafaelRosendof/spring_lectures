package com.exemple.meu_todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/*
 * note que o campo do id tem essa flag para marcar como chave principal 

 já o @GeneratedValue indica que a id será automaticamente gerada quando um novo item ToDo for criado 
 */

@Entity 
//essa classe representa as propriedades do 
public class Todo{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo; //título
    private boolean completo; //completou o cadastro 

    //criando o construtor 
    public Todo(){}

    //criando o construtor 2 
    public Todo(String titulo, boolean completo){
        this.titulo = titulo;
        this.completo = completo;
    }
    //fazendo os métodos gets and sets
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getTitulo(){
        return this.titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public boolean getCompleto(){
        return completo;
    }
    public void setCompleto(boolean completo){
        this.completo = completo;
    }
    /*
     * nesse passo está sendo criado a base para o ToDo list Crud api com a identidade Todo, foi criada 
     * a classe todo como uma JPA entidade dando artributos id titulo e completo, tbm foi feito o design dos construtores
     * para iniciar vazio ou iniciar com um titulo de um booleano e dps implementado os gets and setters 
     */

}
