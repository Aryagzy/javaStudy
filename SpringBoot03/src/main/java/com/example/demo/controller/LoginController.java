package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

@Controller
public class LoginController {
    @RequestMapping("/login/index")
    // 获取两个参数
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        //具体的业务,比如判断用户名或者密码是否正确
        //这里我们假设业务
        //用户名不为空同时密码是123456
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            //登录成功后重定向到index.html中
            //登录成功后设置一个session属性loginUser
            session.setAttribute("loginUser",username);
            return "redirect:/index.html";
        } else {
            //提示错误信息
           model.addAttribute("error","用户名或者密码错误🙅");
            return "login";
        }
    }
}
