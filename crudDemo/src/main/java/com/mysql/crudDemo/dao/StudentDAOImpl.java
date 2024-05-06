package com.mysql.crudDemo.dao;
import java.util.List;
import com.mysql.crudDemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository; //verificar isso dps
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{
    //definido campo para entidade 
    //injetando entidade com injeção 
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional //atualizando o banco de dados
    public void save(Student thStudent){

        entityManager.persist(thStudent);

    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll(){
        //criar uma querry  e retornar 
                            //aqui fica aQuery msm, melhor 
        TypedQuery<Student> aQuery = entityManager.createQuery("FROM Student" , Student.class);
            //order by ... para ordenar a saida

        return aQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String thelastName){
        TypedQuery<Student> aQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData" ,Student.class );

        //setando a query
        aQuery.setParameter("theData", thelastName);

        //devolvendo
        return aQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student thStudent) {
        // TODO Auto-generated method stub
        entityManager.merge(thStudent); //atualizando o nome, seja nome ou qualquer objeto é a mesma coisa 
        
    }

    @Override
    @Transactional
    public void delete(Integer id){
       Student thStudent = entityManager.find(Student.class , id); 
       entityManager.remove(thStudent);
    }

    @Override
    @Transactional
    public int deleteAll(){
        int numDelete = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numDelete;
    }
}