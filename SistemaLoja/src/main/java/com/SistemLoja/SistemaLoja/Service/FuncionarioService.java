package com.SistemLoja.SistemaLoja.Service;

import com.SistemLoja.SistemaLoja.DAO.FuncionarioDAO;
import com.SistemLoja.SistemaLoja.Entity.FuncionarioEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemLoja.SistemaLoja.DAO.CustomFuncDAO;

/*
 * 
 *     FuncionarioEntity findByCpf(String cpf); 

    void CriarFuncionario(FuncionarioEntity funcionario);

    void updateFuncionario(FuncionarioEntity funcionario);
 */

@Service
public class FuncionarioService{

    @Autowired
    private final FuncionarioDAO funcionarioDAO;
    private final CustomFuncDAO customFuncDAO;

    public FuncionarioService(FuncionarioDAO funcionarioDAO , CustomFuncDAO customFuncDAO){
        this.funcionarioDAO = funcionarioDAO;
        this.customFuncDAO = customFuncDAO;
    }

    public void deleteById(int id){
        funcionarioDAO.deleteById(id);
    }

    public FuncionarioEntity findById(int id){
        return funcionarioDAO.findById(id).orElse(null);
    }

    public FuncionarioEntity findByCpf(String cpf){
        return customFuncDAO.findByCpf(cpf);
    }

    public void CriarFuncionario(FuncionarioEntity funcionario){
        customFuncDAO.CriarFuncionario(funcionario);
    }

    public void updateFuncionario(FuncionarioEntity funcionario){
        customFuncDAO.updateFuncionario(funcionario);

    }
}