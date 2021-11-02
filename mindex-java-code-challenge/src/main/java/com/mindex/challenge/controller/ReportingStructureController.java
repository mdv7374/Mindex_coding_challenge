package com.mindex.challenge.controller;

import java.util.List;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ReportingStructure")
@RestController
public class ReportingStructureController {
    private final EmployeeService employeeService;

    @Autowired
    public ReportingStructureController(EmployeeService employeeService){
        this.employeeService =employeeService;
    }

    public int calcNumberOfReports(Employee employee, int numOfReports){
        List<Employee> directReports = employee.getDirectReports();
        if(directReports == null){
            return 0;
        }
        if(directReports.size() == 0){
            return 0;
        }
            for(int i = 0; i<directReports.size();i++){
            numOfReports++;
            Employee temp = employeeService.read(directReports.get(i).getEmployeeId());
            numOfReports = numOfReports + calcNumberOfReports(temp,0);       
        }
        return numOfReports;
    }

    @PostMapping(path = "{id}")
    public ReportingStructure getReportingStructure(@PathVariable("id") String id){
        Employee employee = employeeService.read(id);
        int reports = calcNumberOfReports(employee, 0);
        return new ReportingStructure(employee, reports);
    }
}
