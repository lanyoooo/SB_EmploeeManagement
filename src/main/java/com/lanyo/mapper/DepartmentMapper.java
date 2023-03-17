package com.lanyo.mapper;

import com.lanyo.pojo.department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Mapper
@Repository
public interface DepartmentMapper {
    //根据id查询信息
    department getDepartmentById(Integer id);

    //返回所有的信息
    Collection<department> getAllDepartments();
}
