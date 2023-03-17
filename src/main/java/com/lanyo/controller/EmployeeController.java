package com.lanyo.controller;

import com.lanyo.dao.DepartmentDao;
import com.lanyo.dao.EmployeeDao;
import com.lanyo.pojo.department;
import com.lanyo.pojo.employee;
import com.lanyo.services.DepartmentService;
import com.lanyo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Controller
public class EmployeeController {

//    @Autowired
//    EmployeeDao employeeDao;

    @Autowired
    EmployeeService employeeService;

//    @Autowired
//    DepartmentDao departmentDao;

    @Autowired
    DepartmentService departmentService;



    //展示所有员工
    @RequestMapping("/emps")
    public String getAllEmployees(Model model){
        List<employee> allEmployee = employeeService.getAllEmployees();

        for (employee employee : allEmployee) {
            employee.setDepartment(departmentService.getDepartmentById(employee.getDept_id()));
        }
        //System.out.println(allEmployee);
        model.addAttribute("emps",allEmployee);
        return "emp/list";
    }

    //跳转到增加员工页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //需要注入部门的信息
        Collection<department> allDepartments = departmentService.getAllDepartments();
        model.addAttribute("departments",allDepartments);
        return "emp/add";
    }

    //添加新员工，并返回到员工列表
    @PostMapping("/emp")
    public String addEmployee(employee employee){
        //System.out.println("表单提交了");
        //添加的操作
        //System.out.println(employee);
        employee.setDept_id(employee.getDepartment().getId());
        employeeService.addEmployee(employee);
        return "redirect:/emps";
    }

    //跳转到员工的修改页面
    @GetMapping("/emp/{id}")
    public String toUpdate(@PathVariable("id")Integer id, Model model){
        //查出原来的数据
        employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("emp",employee);
        //把部门的数据传过去
        Collection<department> allDepartments = departmentService.getAllDepartments();
        model.addAttribute("departments",allDepartments);
        return "emp/update";
    }

    //提交修改后的员工信息
    @RequestMapping("/updateEmp")
    public String updateEmp(employee employee){
        //System.out.println("修改后的员工数据==>"+ employee);
        employee.setDept_id(employee.getDepartment().getId());
        employeeService.updateEmployee(employee);
        return "redirect:/emps";
    }

    //删除员工
    @GetMapping("/delete/{id}")
    public String dleteEmployee(@PathVariable("id")Integer id){
        //System.out.println("Debug===>将要删除===>"+employeeDao.getEmployeeById(id));
        employeeService.deleteEmployeeById(id);
        return "redirect:/emps";
    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index";
    }

}
