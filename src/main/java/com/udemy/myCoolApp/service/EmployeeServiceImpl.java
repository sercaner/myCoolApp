package com.udemy.myCoolApp.service;

import com.udemy.myCoolApp.dao.EmployeeRepository;
import com.udemy.myCoolApp.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository TheEmployeeRepository) {
        this.employeeRepository = TheEmployeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee employee = null;
        if (result.isPresent()) {
            employee = result.get();
        }else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
