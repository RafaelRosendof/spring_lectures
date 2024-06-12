//serviço de transações 
package com.trabalho.pix.Service;
import java.math.BigDecimal;

public interface TransactionService{
    void transferir(String contaRemetente , String contaRecebedor , BigDecimal valor);
}