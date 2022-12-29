package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
  在template目录下的所有页面，只能通过controller跳转
  这个需要模版引擎的支持！ thymeleaf 模版引擎还有jsp
*/
@Controller
public class IndexController {
    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("msg","hello thymeleaf");
        model.addAttribute("link","www.baidu.com");
        // 返回视图层
        return "test";
    }
}
