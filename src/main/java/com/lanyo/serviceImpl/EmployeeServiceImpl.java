package com.lanyo.serviceImpl;

import com.lanyo.dao.DepartmentDao;
import com.lanyo.dao.EmployeeDao;
import com.lanyo.pojo.employee;
import com.lanyo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @Override
    public void addEmployee(employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public employee getEmployeeById(Integer id) {
        employee employee = employeeDao.getEmployeeById(id);
        return employee;
    }

    @Override
    public List<employee> getAllEmployees() {
        List<employee> employees = employeeDao.getAllEmployee();
        return employees;
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeDao.deleteEmployeeById(id);
    }

    @Override
    public void updateEmployee(employee employee) {
        employeeDao.updateEmployee(employee);
    }
}
