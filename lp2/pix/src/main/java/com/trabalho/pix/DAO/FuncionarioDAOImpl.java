package com.trabalho.pix.DAO;

import java.util.List;

//import javax.swing.text.html.parser.Entity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trabalho.pix.entity.ClienteEntity;
import com.trabalho.pix.entity.FuncionarioEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class FuncionarioDAOImpl implements FuncionarioDAO {
   
   private EntityManager entityManager;

   @Autowired
   public FuncionarioDAOImpl(EntityManager entityManager){
      this.entityManager = entityManager;
   }

   @Override
   @Transactional
   public void criarCliente(ClienteEntity clienteEntity){
      entityManager.persist(clienteEntity);
   }

   @Override
   public ClienteEntity findById(Integer id){
      return entityManager.find(ClienteEntity.class , id);
   }

   @Override
   public FuncionarioEntity findFun(Integer id){
      return entityManager.find(FuncionarioEntity.class , id);
   }

   @Override
   public List<ClienteEntity> findAll(){
      TypedQuery<ClienteEntity> aQuery = entityManager.createQuery("FROM Cliente", ClienteEntity.class); //verificar se é esse banco mesmo 

      return aQuery.getResultList();
   }

   @Override
   @Transactional
   public void updateCliente(ClienteEntity clienteEntity){
      entityManager.merge(clienteEntity);
   }

   @Override
   @Transactional
   public void deleteCliente(Integer id){
      ClienteEntity clienteEntity = entityManager.find(ClienteEntity.class , id);
      entityManager.remove(clienteEntity);
   }

   @Override
   @Transactional
   public void criaFuncionario(FuncionarioEntity funcionarioEntity){
      entityManager.persist(funcionarioEntity);
   }

   @Override
   @Transactional
   public void updateFuncionario(FuncionarioEntity funcionarioEntity){
      entityManager.merge(funcionarioEntity);
   }

   @Override
   @Transactional
   public void deleteFuncionario(Integer id){
      FuncionarioEntity funcionarioEntity = entityManager.find(FuncionarioEntity.class , id);

      entityManager.remove(funcionarioEntity);
   }

}

