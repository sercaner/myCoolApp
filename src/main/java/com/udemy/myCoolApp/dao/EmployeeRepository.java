package com.udemy.myCoolApp.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.udemy.myCoolApp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

    // add a method to sort  by last name
    public List<Employee> findAllByOrderByLastNameAsc();
}
