package com.trabalho.pix.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trabalho.pix.entity.TransactionEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class TransactionDAOImpl implements TransactionDAO{
    @PersistenceContext
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
