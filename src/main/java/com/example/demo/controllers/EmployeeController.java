package com.example.demo.controllers;

import com.example.demo.entities.PersistableEmployee;
import com.example.demo.mappers.EmployeeMapper;
import com.example.demo.models.Employee;
import com.example.demo.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/api/")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping(value = "/v1/employees", produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK) // 200
    public List<Employee> getEmployees() {
        log.debug("Request received.");
        return employeeService.getEmployees().stream().map(employeeMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping(value = "/v1/employees/{id}", produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK) // 200
    public Employee getEmployeeById(@PathVariable("id") final String id) {
        log.debug("Request received.");
        return employeeMapper.toDto(employeeService.getEmployeeById(id));
    }

    @GetMapping(value = "/v1/employees?{ids}", produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK) // 200
    public List<Employee> getEmployeeByIds(@PathParam("ids") final List<String> ids) {
        log.debug("Request received.");
        return employeeService.getEmployeeByIds(ids).stream().map(employeeMapper::toDto).collect(Collectors.toList());
    }

    @PostMapping(value = "/v1/employees", produces = "application/json")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Employee saveEmployee(@RequestBody Employee employee) {
        log.debug("Request received.");
        PersistableEmployee persistableEmployee = employeeService.saveEmployee(employeeMapper.toEntity(employee));
        return employeeMapper.toDto(persistableEmployee);
    }
}