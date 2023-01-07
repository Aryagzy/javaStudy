package com.example.demo.controller;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.pojo.Department;
import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class MemberList {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/memberlist")
    public String list(Model model){
        Collection<Employee> employees =employeeDao.getAll();
        model.addAttribute("page","/member/member-list");
        model.addAttribute("emp",employees);
         return "member/member-list";
    }

    //请求添加页面
    @GetMapping("/member-add")
    public String addMemberPage(Model model){
        //查询出所有的部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        //把部门信息返回给前端页面
        model.addAttribute("departments",departments);
        return "member/member-add";
    }

    // 提交添加页面，请求接口，
    // 添加数据
    // 返回成员列表页面，数据添加成功，刷新页面
    @PostMapping("/member-add")
    public String addMember(Employee employee){
        //提交表单调用这个接口，把提交的信息添加到数据库中
        // 添加操作
        //调用底层的业务方法保存员工信息
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/memberlist";
    }

}
