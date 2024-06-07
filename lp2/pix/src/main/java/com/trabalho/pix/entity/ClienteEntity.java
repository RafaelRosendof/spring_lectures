//Criar a tabela cliente e os métodos do cliente 

package com.trabalho.pix.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente")
public class ClienteEntity extends UsuarioEntity{

    /*
     * definir campos
     * construtores
     * get e sets
     */
    
    @Column(name = "saldo")
    private BigDecimal saldo;

    @Column(name = "Conta")
    private String conta;

    public ClienteEntity(){}

    public ClienteEntity(String nome , String sobrenome , String login , String senha , BigDecimal saldo, String conta){
        super(nome , sobrenome , login , senha);
        this.saldo = saldo;
        this.conta = conta;
    }

    public BigDecimal getSaldo(){
        return saldo;
    }

    public void setSaldo(BigDecimal saldo){
        this.saldo = saldo;
    }

    public String getConta(){
        return conta;
    }
    public void setConta(String conta){
        this.conta = conta;
    }

    @Override
    public String toString() {
        return "ClienteEntity{" +
                "saldo=" + saldo +
                "conta=" + conta +
                "} " + super.toString();
    }

}