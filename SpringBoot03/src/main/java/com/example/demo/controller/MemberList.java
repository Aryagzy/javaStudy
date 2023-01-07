package com.example.demo.controller;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.pojo.Department;
import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class MemberList {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/member-list")
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
        employeeDao.save(employee);
        return "redirect:/member-list";
    }

    //点击编辑获取到编辑页面
    @GetMapping("/member-edit/{id}")
    public String editMemberPage(@PathVariable("id")Integer id,Model model){
        //查出所有数据显示到编辑页面中
       Employee employee = employeeDao.getEmployeeById(id);
       model.addAttribute("emp",employee);
        // 跳转到编辑页面
        return "member/member-edit";
    }
    @PostMapping("/edit")
    public String editMember(Employee employee){
        // 修改以后要要保存数据
        employeeDao.save(employee);
        // 重定定向到member-list中，刷新列表数据
        return "redirect:/member-list";
    }

}
