package com.SistemLoja.SistemaLoja.Service;

import java.util.List;
import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemLoja.SistemaLoja.DAO.ClienteDAO;
import com.SistemLoja.SistemaLoja.Entity.ClienteEntity;

import jakarta.transaction.Transactional;

import com.SistemLoja.SistemaLoja.DAO.CustomDAOCliente;


@Service
public class ClienteService{
    private final ClienteDAO clienteDAO;
    private final CustomDAOCliente customDAOCliente;

    @Autowired
    public ClienteService(ClienteDAO clienteDAO, CustomDAOCliente customDAOCliente){
        this.clienteDAO = clienteDAO;
        this.customDAOCliente = customDAOCliente;
    }

    //TODO

    public ClienteEntity findById(int id){
        Optional<ClienteEntity> cliente = clienteDAO.findById(id);
        return cliente.orElse(null);
    }

    public void deleteById(int id){
        clienteDAO.deleteById(id);
    }

    @Transactional
    public ClienteEntity updateCliente(ClienteEntity cliente){
        ClienteEntity clienteEntity = clienteDAO.findById(cliente.getId()).orElse(null);
        if(clienteEntity == null){
            return null;
        }
        customDAOCliente.updateCliente(cliente);
        return cliente;
    }

    @Transactional
    public ClienteEntity CriarCliente(ClienteEntity cliente){
        customDAOCliente.CriarCliente(cliente);
        return cliente;
    }

    public ClienteEntity findConta(int id){
        return customDAOCliente.findConta(id);
    }

    public ClienteEntity findByCpf(String cpf){
        return customDAOCliente.findByCpf(cpf);
    }

    public BigDecimal findSaldo(int id){
        return customDAOCliente.findSaldo(id);
    }

    public List<ClienteEntity> findAll(){
        return clienteDAO.findAll();
    }
}