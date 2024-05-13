//to-do  

package com.crudEscola.escola.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crudEscola.escola.entidade.Usuario;

import io.micrometer.observation.annotation.Observed;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Repository

public class UsuarioDAOimpl implements UsuarioDAO{
   //definindo campos para entidade e injeção  

   private EntityManager entityManager;

   @Autowired
   public UsuarioDAOimpl(EntityManager entityManager){
    this.entityManager = entityManager;
   }

   @Override
   @Transactional
   public void save(Usuario theUsuario){
        entityManager.persist(theUsuario);
   }

   @Override
   public Usuario findById(Integer id){
    return entityManager.find(Usuario.class, id);
   }

   @Override
   public List<Usuario> findAll(){
    //tem que criar uma query
    TypedQuery<Usuario> aQuery = entityManager.createQuery("FROM Usuario", Usuario.class);

    return aQuery.getResultList();
   }

   @Override
   public List<Usuario> findBySobrenome(String theSobrenome){
    TypedQuery<Usuario> aQuery = entityManager.createQuery("FROM Usuario WHERE sobrenome=:theData" , Usuario.class);

    aQuery.setParameter("theData", theSobrenome);
    return aQuery.getResultList();
   }

   @Override
   @Transactional
   public void update(Usuario theUsuario){
    entityManager.merge(theUsuario);
   }

   @Override
   @Transactional
   public void delete(Integer id){
    Usuario theUsuario = entityManager.find(Usuario.class , id);
    entityManager.remove(theUsuario);
   }

   @Override
   @Transactional
   public int deleteAll(){
    int deletados = entityManager.createQuery("DELETE FROM Usuario").executeUpdate();
    return deletados;
   }


}