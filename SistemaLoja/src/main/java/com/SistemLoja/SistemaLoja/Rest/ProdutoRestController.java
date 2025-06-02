package com.SistemLoja.SistemaLoja.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SistemLoja.SistemaLoja.Entity.ProdutoEntity;
import com.SistemLoja.SistemaLoja.Service.ProdutoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.math.BigDecimal;



@RestController
@RequestMapping("/produto")
public class ProdutoRestController {
    
    private ProdutoService produtoService;


    @Autowired
    public ProdutoRestController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    //métodos a vontade agora 
    /*
    update price
    update quantidade
    update nome
     */
    //testado e funcionando
    @GetMapping("/public/ListarProdutos")
    public List<ProdutoEntity> findAll(){
        return produtoService.findAll();
    } 

    //testado e funcionando 
    @GetMapping("/public/produtos/{produtoId}")
    public ProdutoEntity getProduto(@PathVariable int produtoId){
        ProdutoEntity produto = produtoService.findById(produtoId);

        if(produto == null){
            throw new RuntimeException("Produto não encontrado - " + produtoId);
        }


        return produto;
    }

    //está funcionando perfeitamente
    @PostMapping("/adicionarProduto")
    public ProdutoEntity addProduto(@RequestBody ProdutoEntity produto){
        ProdutoEntity dbproduto = produtoService.CriarProduto(produto);

        return dbproduto;
    }

    //funcionando, apenas colocar o valor tbm
    @PutMapping("/{id}/updatePrice")
    public ProdutoEntity updatePrice(@PathVariable int id , @RequestBody BigDecimal price){
       ProdutoEntity produto = produtoService.updatePrice(price , id);

       if(produto == null){
           throw new RuntimeException("Produto não encontrado - " + id);
       }

       return produto;

    }


        //funcionando apenas colocar o valor 
    @PutMapping("/{id}/updateQuantidade")
    public ProdutoEntity updateQuantidade(@PathVariable int id , @RequestBody int value){
        ProdutoEntity produto = produtoService.updateQuantidade(value , id);

        if(produto == null){
            throw new RuntimeException("Produto não encontrado - " + id);
        }

        return produto;
    }

    @DeleteMapping("/delete/{produtoId}")
    public void deleteProduto(@PathVariable int produtoId){
        ProdutoEntity produto = produtoService.findById(produtoId);

        if(produto == null){
            throw new RuntimeException("Produto não encontrado - " + produtoId);
        }

        produtoService.deleteById(produtoId);
    }
}

/*
 * {
  "id": 1,
  "nome": "Notebook",
  "categoria": "Eletrônicos",
  "price": 2500.00,
  "quantidade": 10,
  "marca": "Dell"
}

 */