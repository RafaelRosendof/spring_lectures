//criar as assinaturas dos métodos e chamar do service as transações e saldos a view não pode se comunicar com o dao diretamente 

package com.trabalho.pix.DAO;

import java.math.BigDecimal;

import com.trabalho.pix.entity.ClienteEntity;
import com.trabalho.pix.DAO.TransactionDAO;

public interface ClienteDAO{
    
    BigDecimal consultarSaldo(ClienteEntity cliente); 

    ClienteEntity findConta(String conta); 

 
    String meusDados(String conta);

    void updateCliente(ClienteEntity cliente);
}