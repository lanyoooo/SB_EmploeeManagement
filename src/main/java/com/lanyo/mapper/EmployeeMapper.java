package com.lanyo.mapper;

import com.lanyo.pojo.employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {

    void addEmployee(employee employee);

    employee getEmployeeById(Integer id);

    List<employee> getAllEmployee();

    void deleteEmployeeById(Integer id);

    void updateEmployee(employee employee);

    //void save(employee employee);
}
