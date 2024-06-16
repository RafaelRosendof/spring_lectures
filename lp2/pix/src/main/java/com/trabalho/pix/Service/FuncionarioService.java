package com.trabalho.pix.Service;

import java.util.List;
import com.trabalho.pix.entity.*;

public interface FuncionarioService{
    void criarCliente(ClienteEntity cliente);

    ClienteEntity findById(Integer id);

    FuncionarioEntity findFun(Integer id);

    List<ClienteEntity> findAll();

    void updateCliente(ClienteEntity cliente);

    void deleteCliente(Integer id);

    void criarFuncionario(FuncionarioEntity funcionario);

    void updateFuncionario(FuncionarioEntity funcionario);

    void deleteFuncionario(Integer id);
}