package com.trabalho.pix.DAO;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.trabalho.pix.entity.ClienteEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

public class ClienteDAOImpl implements ClienteDAO{
    

  
   private EntityManager entityManager;

   @Autowired
   public ClienteDAOImpl(EntityManager entityManager){
      this.entityManager = entityManager;
   }

   @Override
   public ClienteEntity findConta(String conta){
      TypedQuery<ClienteEntity> aQuery = entityManager.createQuery("FROM CLiente WHERE conta = :conta", ClienteEntity.class);
      aQuery.setParameter("conta", conta);
      return aQuery.getSingleResult();
   }

   @Override
   public BigDecimal consultarSaldo(ClienteEntity cliente){
      return cliente.getSaldo(); //fazer isso na view
   }


   @Override
   @Transactional
   public void updateCliente(ClienteEntity cliente){
      entityManager.persist(cliente);
   }

   @Override
   public String meusDados(String conta){
      //ClienteEntity clienteEntity = entityManager.find(ClienteEntity.class , conta);
      //return clienteEntity.toString();
      TypedQuery<ClienteEntity> query = entityManager.createQuery( "SELECT c FROM Cliente c WHERE c.conta = :conta", ClienteEntity.class);
      query.setParameter("conta", conta);

      ClienteEntity clienteEntity;
      try{
         clienteEntity = query.getSingleResult();
      }catch( Exception e){
         return "Conta não encontrada";
      }

      return clienteEntity.toString();
   }

}