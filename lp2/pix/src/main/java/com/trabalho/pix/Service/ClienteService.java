package com.trabalho.pix.Service;

import java.math.BigDecimal;

public interface ClienteService{
    void transferir(String contaRemetente, String contaRecebedor, BigDecimal valor);
    BigDecimal consultarSaldo(String conta);  
}