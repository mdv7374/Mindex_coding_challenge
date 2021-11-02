package com.mindex.challenge.dao;

import java.util.Optional;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;

public interface CompensationDao {
    int insertCompensation(Employee employee, int salary, String effectiveDate);
    Optional<Compensation> selectCompensationById(String id);
}
