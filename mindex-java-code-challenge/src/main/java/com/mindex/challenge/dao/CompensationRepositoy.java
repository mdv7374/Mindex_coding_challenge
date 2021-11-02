package com.mindex.challenge.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;

import org.springframework.stereotype.Repository;

@Repository("CompensationDao")
public class CompensationRepositoy implements CompensationDao{

    private static List<Compensation> DB = new ArrayList<>();
    @Override
    public int insertCompensation(Employee employee, int salary, String effectiveDate) {
        DB.add(new Compensation(employee, salary, effectiveDate));
        return 1;
    }

    @Override
    public Optional<Compensation> selectCompensationById(String id){
        // TODO Auto-generated method stub
        return DB.stream().filter(compensation -> compensation.getEmployee().getEmployeeId().equals(id)).findFirst();
    }
    
}
