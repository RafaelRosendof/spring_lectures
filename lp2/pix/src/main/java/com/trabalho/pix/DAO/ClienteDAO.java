//criar as assinaturas dos métodos e chamar do service as transações e saldos a view não pode se comunicar com o dao diretamente 

package com.trabalho.pix.DAO;

import java.math.BigDecimal;

import com.trabalho.pix.entity.ClienteEntity;

public interface ClienteDAO{
    BigDecimal enviarDinheiro(String conta);
    BigDecimal consultarSaldo(); 
}