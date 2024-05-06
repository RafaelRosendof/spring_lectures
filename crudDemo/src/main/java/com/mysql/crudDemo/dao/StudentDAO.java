package com.mysql.crudDemo.dao;
import com.mysql.crudDemo.entity.Student;
import java.util.List;

public interface StudentDAO {

    void save(Student thStudent);

    Student findById(Integer id);

    //novo método para consulta???
    List<Student> findAll();

    List<Student> findByLastName(String thelastName);

    void update(Student thStudent);

    void delete(Integer id);

    int deleteAll();
    
}