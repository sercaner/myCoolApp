package com.udemy.myCoolApp.dao;

import com.udemy.myCoolApp.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);
    Student findById(Integer id);
}
