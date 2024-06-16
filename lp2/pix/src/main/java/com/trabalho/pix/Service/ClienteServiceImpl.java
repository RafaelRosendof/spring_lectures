package com.trabalho.pix.Service;

import java.math.BigDecimal;
import com.trabalho.pix.DAO.ClienteDAO;

import jakarta.transaction.Transactional;
import com.trabalho.pix.entity.ClienteEntity;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ClienteServiceImpl implements ClienteService{

    private final ClienteDAO clienteDAO;
    //private final TransactionService transactionService;

    @Autowired
    public ClienteServiceImpl(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
//        this.transactionService = transactionService;
    }


    @Override
    public BigDecimal consultarSaldo(String conta){
        ClienteEntity cliente = clienteDAO.findConta(conta);
        return clienteDAO.consultarSaldo(cliente);
    }

    @Override
    public String meusDados(String conta){
       return clienteDAO.meusDados(conta); 
    }

}