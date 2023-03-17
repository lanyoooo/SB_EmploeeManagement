package com.lanyo.dao;

import com.lanyo.mapper.DepartmentMapper;
import com.lanyo.pojo.department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class DepartmentDao {
    @Autowired
    DepartmentMapper departmentMapper;

    //根据id查询信息
    public department getDepartmentById(Integer id){
        return departmentMapper.getDepartmentById(id);
    }

    //返回所有的信息
    public Collection<department> getAllDepartments(){//注意是Collection，没有最后的s
        return departmentMapper.getAllDepartments();
    }


}
