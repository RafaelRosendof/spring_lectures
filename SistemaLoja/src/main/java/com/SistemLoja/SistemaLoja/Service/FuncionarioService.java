package com.SistemLoja.SistemaLoja.Service;

import com.SistemLoja.SistemaLoja.DAO.FuncionarioDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemLoja.SistemaLoja.DAO.CustomFuncDAO;

@Service
public class FuncionarioService{

    @Autowired
    private final FuncionarioDAO funcionarioDAO;
    private final CustomFuncDAO customFuncDAO;

    public FuncionarioService(FuncionarioDAO funcionarioDAO , CustomFuncDAO customFuncDAO){
        this.funcionarioDAO = funcionarioDAO;
        this.customFuncDAO = customFuncDAO;
    }

    //TODO

}