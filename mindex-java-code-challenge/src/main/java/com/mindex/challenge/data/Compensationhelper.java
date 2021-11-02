package com.mindex.challenge.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Compensationhelper {
    private int salary;
    private String effectiveDate;
    public Compensationhelper(@JsonProperty("salary") int salary, @JsonProperty("effectiveDate") String effectiveDate){
        this.salary = salary;
        this.effectiveDate = effectiveDate;
    }

    public int getSalary(){
        return salary;
    }

    public String getEffectiveDate(){
        return effectiveDate;
    }
}
