package com.trabalho.pix.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalho.pix.DAO.FuncionarioDAO;
import com.trabalho.pix.entity.ClienteEntity;
import com.trabalho.pix.entity.FuncionarioEntity;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{

    private final FuncionarioDAO funcionarioDAO;

    @Autowired
    public FuncionarioServiceImpl(FuncionarioDAO funcionarioDAO){
        this.funcionarioDAO = funcionarioDAO;
    }

    @Override
    public void criarCliente(ClienteEntity cliente){
        funcionarioDAO.criarCliente(cliente);
    }

    @Override
    public ClienteEntity findById(Integer id){
        return funcionarioDAO.findById(id);
    }


    @Override
    public FuncionarioEntity findFun(Integer id){
        return funcionarioDAO.findFun(id);
    }
    @Override
    public List<ClienteEntity> findAll(){
        return funcionarioDAO.findAll();
    }

    @Override
    public void updateCliente(ClienteEntity cliente){
        funcionarioDAO.updateCliente(cliente);
    }

    @Override
    public void deleteCliente(Integer id){
        funcionarioDAO.deleteCliente(id);
    }

    @Override
    public void criarFuncionario(FuncionarioEntity funcionario){
        funcionarioDAO.criaFuncionario(funcionario);
    }

    @Override
    public void updateFuncionario(FuncionarioEntity funcionario){
        funcionarioDAO.updateFuncionario(funcionario);
    }

    @Override
    public void deleteFuncionario(Integer id){
        funcionarioDAO.deleteFuncionario(id);
    }

}

