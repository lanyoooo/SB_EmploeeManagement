package com.lanyo.pojo;

import com.lanyo.dao.DepartmentDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;//0女  1男
    private Integer dept_id;
    private department department;
    private Date birth;//在数据库中的实验数据不会有birth，但是在显示时候会有一个查表时生成的时间，如果是手动添加的数据就会有birth
}
