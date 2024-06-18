package com.trabalho.pix.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trabalho.pix.entity.ClienteEntity;
import com.trabalho.pix.entity.FuncionarioEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
//import org.springframework.transaction.annotation.Transactional;

@Repository
public class AutenticaDAO {
   
    @PersistenceContext
    private EntityManager entityManager;
    
    public AutenticaDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Transactional
    public FuncionarioEntity findFuncionario(String login , String senha){
        TypedQuery<FuncionarioEntity> aQuery = entityManager.createQuery("SELECT f FROM FuncionarioEntity f WHERE f.login = :login AND f.senha = :senha", FuncionarioEntity.class);
        aQuery.setParameter("login", login);
        aQuery.setParameter("senha", senha);

        return aQuery.getResultStream().findFirst().orElse(null);
    }

    @Transactional
    public FuncionarioEntity findGerente(String login , String senha){
        TypedQuery<FuncionarioEntity> aQuery = entityManager.createQuery("SELECT f FROM FuncionarioEntity f WHERE f.login = :login AND f.senha = :senha", FuncionarioEntity.class);
        aQuery.setParameter("login", login);
        aQuery.setParameter("senha", senha);

        return aQuery.getResultStream().findFirst().orElse(null);
    }

    @Transactional
    public ClienteEntity findCliente(String login , String senha){
        TypedQuery<ClienteEntity> query = entityManager.createQuery(
                "SELECT c FROM ClienteEntity c WHERE c.login = :login AND c.senha = :senha", 
                ClienteEntity.class);
        query.setParameter("login", login);
        query.setParameter("senha", senha);
        return query.getResultStream().findFirst().orElse(null);
    }

}
