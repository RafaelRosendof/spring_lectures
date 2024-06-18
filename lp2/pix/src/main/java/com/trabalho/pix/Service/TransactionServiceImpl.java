package com.trabalho.pix.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalho.pix.DAO.ClienteDAO;
import com.trabalho.pix.entity.ClienteEntity;
import com.trabalho.pix.entity.TransactionEntity;

import jakarta.transaction.Transactional;

import com.trabalho.pix.DAO.TransactionDAO;

//import jakarta.persistence.EntityManager;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final ClienteDAO clienteDAO;
    private final TransactionDAO transactionDAO;

    @Autowired
    public TransactionServiceImpl(TransactionDAO transactionDAO , ClienteDAO clienteDAO){
        this.transactionDAO = transactionDAO;
        this.clienteDAO = clienteDAO;
    }
    @Override
    @Transactional
    public void transferir(String contaRemetente , String contaRecebedor , BigDecimal valor){ //atualizar as contas e não clientes  (verificar o que é isso)

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

        //REGISTRANDO A TRANSFERENCIA chamar metodo do DAO para salvar 
        TransactionEntity transferenciaEntity = new TransactionEntity(remetente, recebedor, valor, LocalDateTime.now());
        transactionDAO.registrarTransacao(transferenciaEntity);

    }
}
