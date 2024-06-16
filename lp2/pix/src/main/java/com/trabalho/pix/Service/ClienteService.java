package com.trabalho.pix.Service;

import java.math.BigDecimal;

import com.trabalho.pix.DAO.ClienteDAO;

public interface ClienteService{
   // void transferir(String contaRemetente, String contaRecebedor, BigDecimal valor);
    BigDecimal consultarSaldo(String conta);  

    String meusDados(String conta);
}