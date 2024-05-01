package com.udemy.myCoolApp.dao;

import com.udemy.myCoolApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // /magic-api/employees?sort=lastName,desc
}
