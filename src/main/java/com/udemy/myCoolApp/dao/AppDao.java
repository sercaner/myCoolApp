package com.udemy.myCoolApp.dao;

import com.udemy.myCoolApp.entity.Instructor;
import com.udemy.myCoolApp.entity.InstructorDetail;

public interface AppDao {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail  findInstructorDetailById(int id);
}
