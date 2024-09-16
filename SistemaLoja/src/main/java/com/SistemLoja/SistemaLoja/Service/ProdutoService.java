package com.SistemLoja.SistemaLoja.Service;


import org.springframework.stereotype.Service;

import com.SistemLoja.SistemaLoja.DAO.ProdutoDAO;
import com.SistemLoja.SistemaLoja.DAO.CustomProdDAO;


@Service
public class ProdutoService{
    private final ProdutoDAO produtoDAO;
    private final CustomProdDAO customDAOProduto;

    public ProdutoService(ProdutoDAO produtoDAO , CustomProdDAO customDAOProduto){
        this.produtoDAO = produtoDAO;
        this.customDAOProduto = customDAOProduto;
    }

    //TODO mesma coisa de antes crud básico e os métodos customizados
}
