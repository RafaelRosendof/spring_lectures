//criar a tabela funcionario com as suas caracteristicas get e sets 

package com.trabalho.pix.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Funcionario")
public class FuncionarioEntity extends UsuarioEntity{
/*
 * Colunas adicionais ( id nome sobrenome login e senha tipo só esse  ) 
 * construtor default e fixo
 * gets and sets 
 */
    @Column(name = "categoria")
    private String categoria;

    public FuncionarioEntity(){}

    public FuncionarioEntity(String nome , String sobrenome , String login , String senha , String categoria){
        super(nome , sobrenome , login , senha);
        this.categoria = categoria;
    }

   public String getCategoria(){
    return categoria;
   } 
   public void setCategoria(String categoria){
    this.categoria = categoria;
   }

   @Override
   public String toString(){
    return "FuncionarioEntity{" +
            "Categoria="+ categoria +
            "} " + super.toString();
   }
}