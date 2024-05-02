package com.udemy.myCoolApp.service;

import java.util.List;
import com.udemy.myCoolApp.entity.Employee;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee findById(int theId);

    public Employee save(Employee theEmployee);

    public void deleteById(int theId);
}
