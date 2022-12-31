package com.example.demo.controller;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class MemberList {
    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping("/memberlist")
    public String list(Model model){
        Collection<Employee> employees =employeeDao.getAll();
        model.addAttribute("page","/member/member-list");
        model.addAttribute("emp",employees);
         return "member/member-list";
    }

}
