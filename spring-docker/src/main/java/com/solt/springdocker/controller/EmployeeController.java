package com.solt.springdocker.controller;

import com.solt.springdocker.model.Employee;
import com.solt.springdocker.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/create")
    public String  createEmployee(){
        Arrays.asList(new Employee("Thaw Thaw","HR",300000),
                new Employee("Thaw Thaw","HR",200000),
                new Employee("Thaw Thaw","HR",100000)
                )
        .forEach(employeeRepository::save);


        return "Successfully Create";



    }

    @GetMapping("/all")
    public List<Employee> findAllEmployee(){
        return employeeRepository.findAll();
    }
}
