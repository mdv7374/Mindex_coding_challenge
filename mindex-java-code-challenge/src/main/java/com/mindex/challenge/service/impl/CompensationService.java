package com.mindex.challenge.service.impl;

import java.util.Optional;

import com.mindex.challenge.dao.CompensationDao;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CompensationService {
    private final CompensationDao compensationDao;

    @Autowired
    public CompensationService(@Qualifier("CompensationDao") CompensationDao compensationDao){
        this.compensationDao = compensationDao;
    }

    public int addCompensation(Employee employee, int salary, String effectiveDate){
        return compensationDao.insertCompensation(employee, salary, effectiveDate);
    }

    public Optional<Compensation> getCompensationById(String id){
        return compensationDao.selectCompensationById(id);
    }
}
