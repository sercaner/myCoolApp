package com.udemy.myCoolApp.dao;

import com.udemy.myCoolApp.entity.Instructor;
import com.udemy.myCoolApp.entity.InstructorDetail;
import jakarta.persistence.EntityManager;

public class AppDaoImp implements AppDao{

    private EntityManager entityManager;

    public AppDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Instructor instructor) {
    entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public void deleteInstructorById(int id) {
    Instructor tempInstructor = entityManager.find(Instructor.class, id);
    entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }
}
