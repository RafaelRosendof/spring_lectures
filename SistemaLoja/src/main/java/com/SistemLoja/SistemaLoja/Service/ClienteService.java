package com.SistemLoja.SistemaLoja.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemLoja.SistemaLoja.DAO.ClienteDAO;
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
}