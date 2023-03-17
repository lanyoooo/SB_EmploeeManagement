package com.lanyo.dao;

import com.lanyo.mapper.EmployeeMapper;
import com.lanyo.pojo.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository     //Service  业务类专用 | Repository  dao实现类专用 | Controller  web层专用 | Component  通用
public class EmployeeDao {

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private EmployeeMapper mapper;


    //增加一个员工
    public void addEmployee(employee employee){
        //前端传回来的对象并不是完整的，部门那一块的属性只有编号，所以需要在代码中根据部门号码得出部门名字并将其赋值，对象才能进一步完整
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        mapper.addEmployee(employee);
    }

    public employee getEmployeeById(Integer id){
        return mapper.getEmployeeById(id);
    }

    public List<employee> getAllEmployee(){
        return mapper.getAllEmployee();
    }

    public void deleteEmployeeById(Integer id){
        mapper.deleteEmployeeById(id);
    }

    public void updateEmployee(employee employee){
        mapper.updateEmployee(employee);
    }
}
