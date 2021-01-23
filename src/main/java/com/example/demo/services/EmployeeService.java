package com.example.demo.services;

import com.example.demo.entities.PersistableEmployee;
import com.example.demo.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<PersistableEmployee> getEmployees() {
        return employeeRepository.findAll();
    }

    public PersistableEmployee saveEmployee(PersistableEmployee e) {
        return employeeRepository.save(e);
    }

    public PersistableEmployee getEmployeeById(final String id) {
        return employeeRepository.findById(id).get();
    }

    public List<PersistableEmployee> getEmployeeByIds(final List<String> ids) {
        return employeeRepository.findAllById(ids);
    }
}