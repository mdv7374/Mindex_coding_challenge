package com.mindex.challenge.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Compensation {
    private Employee employee;
    private int salary;
    private String effectiveDate;
    public Compensation(@JsonProperty("employee") Employee employee,@JsonProperty("salary") int salary,@JsonProperty("effectiveDate") String effectiveDate){
        this.employee = employee;
        this.salary = salary;
        this.effectiveDate = effectiveDate;
    }

    public Employee getEmployee(){
        return employee;
    }
    public int getSalary(){
        return salary;
    }
    public String getEffectiveDate(){
        return effectiveDate;
    }
}
