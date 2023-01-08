package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication:标注这个类是一个springboot应用
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        // SpringBoot类
        // run方法
        SpringApplication.run(DemoApplication.class, args);
    }
}
