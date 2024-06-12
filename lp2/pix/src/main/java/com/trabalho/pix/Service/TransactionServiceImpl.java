package com.trabalho.pix.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.trabalho.pix.DAO.ClienteDAO;
import com.trabalho.pix.entity.ClienteEntity;
import com.trabalho.pix.entity.TransactionEntity;

import jakarta.persistence.EntityManager;

public class TransactionServiceImpl implements TransactionService {

    //todo()! CHAMAR O UPDATE DO CLIENTE PARA ATUALIZAR OS VALORES E PARA PERSISTIR A TRANSAÇÃO feito
    private final EntityManager entityManager;
    private final ClienteDAO clienteDAO;

    @Autowired
    public TransactionServiceImpl(EntityManager entityManager , ClienteDAO clienteDAO){
        this.entityManager = entityManager;
        this.clienteDAO = clienteDAO;
    }

    public void transferir(String contaRemetente , String contaRecebedor , BigDecimal valor){ //atualizar as contas e não clientes 

        ClienteEntity remetente = clienteDAO.findConta(contaRemetente);
        ClienteEntity recebedor = clienteDAO.findConta(contaRecebedor);

        if(remetente.getSaldo().compareTo(valor) < 0){
            throw new IllegalArgumentException("Saldo Insuficiente");
        }

        remetente.setSaldo(remetente.getSaldo().subtract(valor));
        recebedor.setSaldo(recebedor.getSaldo().add(valor));

        // Persistir as mudanças
        clienteDAO.updateCliente(remetente);
        clienteDAO.updateCliente(recebedor);

        //REGISTRANDO A TRANSFERENCIA
        TransactionEntity transferenciaEntity = new TransactionEntity(remetente, recebedor, valor, LocalDateTime.now());
        entityManager.persist(transferenciaEntity);

    }
}
