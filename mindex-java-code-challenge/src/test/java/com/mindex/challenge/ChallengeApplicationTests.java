package com.mindex.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.mindex.challenge.controller.CompensationController;
import com.mindex.challenge.controller.EmployeeController;
import com.mindex.challenge.controller.ReportingStructureController;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Compensationhelper;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//Main file used for testing
@RunWith(SpringRunner.class)
@SpringBootTest
public class ChallengeApplicationTests {

	@Autowired
	EmployeeController employeeController;
	@Autowired
	CompensationController compensationController;
	@Autowired
	ReportingStructureController reportingStructureController;
	private final String id = "16a596ae-edd3-4847-99fe-c4518e82c86f";
	private final int salary = 100000;
	private final String effectiveDate = "11-11-21";
	@Test
	public void contextLoads() {
		//grabbing an employee to compare values to
		Employee employee = employeeController.read(id);
		assertNotNull(employee);
		//testing reportingcontroller
		ReportingStructure reportingStructure = reportingStructureController.getReportingStructure(id);
		assertNotNull(reportingStructure);
		//make sure the value in reporting structure is exactly the same as employee
		assertEquals(employee.getEmployeeId(), reportingStructure.getEmployee().getEmployeeId());
		assertEquals(employee.getDepartment(), reportingStructure.getEmployee().getDepartment());
		assertEquals(employee.getDirectReports().get(0).getEmployeeId(), reportingStructure.getEmployee().getDirectReports().get(0).getEmployeeId());
		assertEquals(employee.getDirectReports().get(1).getEmployeeId(), reportingStructure.getEmployee().getDirectReports().get(1).getEmployeeId());
		assertEquals(employee.getFirstName(), reportingStructure.getEmployee().getFirstName());
		assertEquals(employee.getLastName(), reportingStructure.getEmployee().getLastName());
		assertEquals(employee.getPosition(), reportingStructure.getEmployee().getPosition());
		assertEquals(4, reportingStructure.getNumberOfReports());
		//testing Compensation controller
		//create a new compensationhelper
		Compensationhelper compensationhelper = new Compensationhelper(salary, effectiveDate);
		//add the compensation to the database
		compensationController.addCompensation(id, compensationhelper);
		//retrieve said compensation
		Compensation compensation = compensationController.getCompensationByid(id);
		assertNotNull(compensation);
		//make sure all the values from compensation are correct
		assertEquals(employee.getEmployeeId(), compensation.getEmployee().getEmployeeId());
		assertEquals(employee.getDirectReports().get(0).getEmployeeId(), compensation.getEmployee().getDirectReports().get(0).getEmployeeId());
		assertEquals(employee.getDirectReports().get(1).getEmployeeId(), compensation.getEmployee().getDirectReports().get(1).getEmployeeId());
		assertEquals(employee.getDepartment(), compensation.getEmployee().getDepartment());
		assertEquals(employee.getFirstName(), compensation.getEmployee().getFirstName());
		assertEquals(employee.getLastName(), compensation.getEmployee().getLastName());
		assertEquals(employee.getPosition(), compensation.getEmployee().getPosition());
		assertEquals(salary, compensation.getSalary());
		assertEquals(effectiveDate, compensation.getEffectiveDate());
	}

}
