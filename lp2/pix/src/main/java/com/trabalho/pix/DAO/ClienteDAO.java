//criar as assinaturas dos métodos e chamar do service as transações e saldos a view não pode se comunicar com o dao diretamente 

package com.trabalho.pix.DAO;

import java.math.BigDecimal;

import com.trabalho.pix.entity.ClienteEntity;
import com.trabalho.pix.DAO.TransactionDAO;

public interface ClienteDAO{
    //rever esse método aqui tbm 
    
    //void transferir(String contaRemetente ,String contaRecebedor, BigDecimal valor); //chama a transação? 
    BigDecimal consultarSaldo(ClienteEntity cliente); //tbm não precisa 

    ClienteEntity findConta(String conta); 

   // void transferir(String contaRemetente , String contaRecebedor , BigDecimal valor);

    void updateCliente(ClienteEntity cliente);
}
//REVISAR