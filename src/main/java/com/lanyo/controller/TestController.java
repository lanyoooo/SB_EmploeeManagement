package com.lanyo.controller;

import com.lanyo.dao.DepartmentDao;
import com.lanyo.pojo.department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/testDept")
    public String testDept(){
        department department = departmentDao.getDepartmentById(101);
        System.out.println(department.toString());
        return department.toString();
    }
}
