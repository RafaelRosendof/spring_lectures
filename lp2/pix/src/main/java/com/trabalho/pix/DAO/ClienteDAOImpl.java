package com.trabalho.pix.DAO;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.trabalho.pix.entity.ClienteEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

public class ClienteDAOImpl implements ClienteDAO{
   //chamar transaction aqui?  

  // private TransactionDAO transactionDAO; //rever isso aqui 
   private EntityManager entityManager;

   @Autowired
   public ClienteDAOImpl(EntityManager entityManager){
      this.entityManager = entityManager;
    //  this.transactionDAO = transactionDAO;
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

//TRANSFERENCIA FOI MOVIDO PARA SERVICE TRANSFERENCIA

   @Override
   @Transactional
   public void updateCliente(ClienteEntity cliente){
      entityManager.persist(cliente);
   }
/* 
   @Override
   public void transferir(String contaRemetente , String contaRecebedor , BigDecimal valor){
      ClienteEntity remetente = findConta(contaRemetente);
      ClienteEntity recebedor = findConta(contaRecebedor);

      transactionDAO.transferir(remetente, recebedor, valor);
      //TransactioServ
   }
*/
   }
//REVISAR 