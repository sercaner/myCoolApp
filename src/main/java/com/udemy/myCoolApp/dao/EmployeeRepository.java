package com.udemy.myCoolApp.dao;

import com.udemy.myCoolApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
