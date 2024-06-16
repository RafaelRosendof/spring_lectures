package com.trabalho.pix.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalho.pix.DAO.AutenticaDAO;
import com.trabalho.pix.entity.ClienteEntity;
import com.trabalho.pix.entity.FuncionarioEntity;

@Service
public class AutenticaService {
    private final AutenticaDAO autenticaDAO;

    @Autowired
    public AutenticaService(AutenticaDAO autenticaDAO){
        this.autenticaDAO = autenticaDAO;
    }

    public FuncionarioEntity gerenteFind(String login , String senha){
        return autenticaDAO.findGerente(login,senha);
    }

    public FuncionarioEntity funcionarioFind(String login , String senha){
        return autenticaDAO.findFuncionario(login, senha);
    }

    public ClienteEntity clienteFind(String login , String senha){
        return autenticaDAO.findCliente(login, senha);
    }

}
