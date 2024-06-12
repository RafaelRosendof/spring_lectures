package com.trabalho.pix.DAO;


import org.springframework.beans.factory.annotation.Autowired;

import com.trabalho.pix.entity.TransactionEntity;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

public class TransactionDAOImpl implements TransactionDAO{

    private final EntityManager entityManager;

    @Autowired
    public TransactionDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void registrarTransacao(TransactionEntity transcao){
        entityManager.persist(transcao);
    }

}
