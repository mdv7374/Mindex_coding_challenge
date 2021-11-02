package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Compensationhelper;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.impl.CompensationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/Compensation")
@RestController
public class CompensationController {
    private final CompensationService compensationService;
    private final EmployeeService employeeService;

    @Autowired
    public CompensationController(CompensationService compensationService, EmployeeService employeeService){
        this.compensationService = compensationService;
        this.employeeService = employeeService;
    }

    @PostMapping(path = "{id}")
    public void addCompensation(@PathVariable("id") String id, @RequestBody Compensationhelper compensationhelper){
        Employee employee = employeeService.read(id);
        compensationService.addCompensation(employee, compensationhelper.getSalary(), compensationhelper.getEffectiveDate());
    }

    @GetMapping(path = "{id}")
    public Compensation getCompensationByid(@PathVariable("id") String id){
        return compensationService.getCompensationById(id).orElse(null);
    }
}
