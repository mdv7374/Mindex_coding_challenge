package com.mindex.challenge.data;


public class ReportingStructure {
    private Employee employee;
    private int numberOfReports;

    public ReportingStructure(Employee employee, int numberOfReports){
        this.numberOfReports = numberOfReports;
        this.employee = employee;
    }


    public Employee getEmployee(){
        return employee;
    }

    public int getNumberOfReports(){
        return numberOfReports;
    }
}
