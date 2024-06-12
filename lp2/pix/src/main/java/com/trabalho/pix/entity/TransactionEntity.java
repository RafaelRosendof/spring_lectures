//tabela transação com métodos gets and sets e a lista de transações 
//todo()
package com.trabalho.pix.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;

@Entity
@Table(name = "Transferencias")
public class TransactionEntity{
    /*
     * definir campos 
     * construtor 
     * get e sets  VALE A PENA COLOCAR PAGADOR E RECEBEDOR?
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "remetente_id")
    private ClienteEntity remetente;

    @ManyToOne
    @JoinColumn(name = "recebedor_id")
    private ClienteEntity recebedor;

    private BigDecimal valor;

    private LocalDateTime dataHora;


    public TransactionEntity(){}

    public TransactionEntity(ClienteEntity remetente , ClienteEntity recebedor , BigDecimal valor , LocalDateTime dataHora){
        this.remetente = remetente;
        this.recebedor = recebedor;
        this.valor = valor;
        this.dataHora = dataHora;
    }


    public ClienteEntity getRemetente(){
        return remetente;
    }

    public void setRemetente(ClienteEntity remetente){
        this.remetente = remetente;
    }

    public ClienteEntity recebedor(){
        return recebedor;
    }
    public void setRecebedor(ClienteEntity recebedor){
        this.recebedor = recebedor;
    }

    public BigDecimal getValor(){
        return valor;
    } 
    public void setValor(BigDecimal valor){
        this.valor = valor;
    }

    public LocalDateTime getDataHora(){
        return dataHora;
    } 
    public void setDataHora(LocalDateTime dataHora){
        this.dataHora = dataHora;
    }


//    public void setPagador(String Pagador)
}