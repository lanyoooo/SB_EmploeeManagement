package com.lanyo;

import com.lanyo.dao.EmployeeDao;
import com.lanyo.pojo.department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class SbEmploeeManagementApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    EmployeeDao employeeDao;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());
    }

    @Test
    void testGetDept(){
        department department = employeeDao.getEmployeeById(1001).getDepartment();
        System.out.println(department);
    }

    @Test
    void TestDataSourceType(){
        System.out.println(dataSource.getClass());
    }

}
