package com.luv2code.crudddemo.dao;

import com.luv2code.crudddemo.entity.Student;

import java.util.List;

public interface StudentDao {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
