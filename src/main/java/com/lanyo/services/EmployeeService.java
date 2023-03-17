package com.lanyo.services;

import com.lanyo.dao.EmployeeDao;
import com.lanyo.pojo.employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface EmployeeService {

    void addEmployee(employee employee);

    employee getEmployeeById(Integer id);

    List<employee> getAllEmployees();

    void deleteEmployeeById(Integer id);

    void updateEmployee(employee employee);

}
