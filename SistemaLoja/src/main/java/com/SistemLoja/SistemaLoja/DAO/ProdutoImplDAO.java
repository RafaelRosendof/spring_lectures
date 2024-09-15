package com.SistemLoja.SistemaLoja.DAO;

import java.math.BigDecimal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SistemLoja.SistemaLoja.Entity.ProdutoEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.persistence.Query;

@Repository
public class ProdutoImplDAO implements CustomProdDAO{
     
    @PersistenceContext
    private EntityManager em;

    @Autowired
    public ProdutoImplDAO(EntityManager em){
        this.em = em;
    }


    //essa foi feita pelo gpt, vamos ver né 
    @Override
    public ProdutoEntity findByNome(String nome) {
        TypedQuery<ProdutoEntity> aQuery = em.createQuery("SELECT p FROM ProdutoEntity p WHERE p.nome = :nome", ProdutoEntity.class);
        aQuery.setParameter("nome", nome);
        return aQuery.getSingleResult();
}


    @Override
    @Transactional
    public void CriarProduto(ProdutoEntity produto){
        em.persist(produto);
    }

    @Override
    @Transactional
    public void updatePrice(BigDecimal price , int id){
        Query query = em.createQuery("UPDATE ProdutoEntity p SET p.price = :price WHERE p.id = :id");
        query.setParameter("price", price);
        query.setParameter("id", id);
        query.executeUpdate();

    }

    @Override
    @Transactional
    public void updateQuantidade(int quantidade , int id){
        Query query = em.createQuery("UPDATE ProdutoEntity p SET p.quantidade = :quantidade WHERE id = :id");
        query.setParameter("quantidade", quantidade);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}