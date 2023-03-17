package com.lanyo.services;

import com.lanyo.pojo.department;

import java.util.Collection;

public interface DepartmentService {
    department getDepartmentById(Integer id);

    Collection<department> getAllDepartments();
}
