package com.trabalho.pix.DAO;

import java.util.List;

import com.trabalho.pix.entity.ClienteEntity;
import com.trabalho.pix.entity.FuncionarioEntity;

public interface FuncionarioDAO {

    void criarCliente(ClienteEntity theCliente); //criar cliente 

    ClienteEntity findById(Integer id); //achar cliente 

    FuncionarioEntity findFun(Integer id);

    List<ClienteEntity> findAll(); //buscar todos os clientes 

    void updateCliente(ClienteEntity theCliente); //atualizar cliente 

    void deleteCliente(Integer id); //deletar cliente ou funcionario

    void criaFuncionario(FuncionarioEntity theFuncionario); //criar funcionario

    void updateFuncionario(FuncionarioEntity funcionario); // Atualizar funcionário 

    void deleteFuncionario(Integer id); // Deletar funcionário

    ClienteEntity findByConta(String conta);
}