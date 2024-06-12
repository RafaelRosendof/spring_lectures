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
    private final TransactionService transactionService;

    @Autowired
    public ClienteServiceImpl(ClienteDAO clienteDAO, TransactionService transactionService) {
        this.clienteDAO = clienteDAO;
        this.transactionService = transactionService;
    }

    //todo métodos kkkkkkk

    @Override
    @Transactional
    public void transferir(String contaRemetente , String contaRecebedor , BigDecimal valor){
        transactionService.transferir(contaRemetente, contaRecebedor, valor);
    }

    @Override
    public BigDecimal consultarSaldo(String conta){
        ClienteEntity cliente = clienteDAO.findConta(conta);
        return clienteDAO.consultarSaldo(cliente);
    }

}