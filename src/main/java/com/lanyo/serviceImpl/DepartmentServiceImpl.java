package com.lanyo.serviceImpl;

import com.lanyo.dao.DepartmentDao;
import com.lanyo.pojo.department;
import com.lanyo.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    @Override
    public department getDepartmentById(Integer id) {
        return departmentDao.getDepartmentById(id);
    }

    @Override
    public Collection<department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }
}
