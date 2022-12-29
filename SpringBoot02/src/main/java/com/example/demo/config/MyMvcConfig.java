package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

// 如果你想diy一些定制化功能，只要写这个组件，然后将它交给springboot,springboot就会帮我们自动装配！
// 扩展springmvc  dispatchservlet
// 类型要求为WebMvcConfigurer，所以我们实现接口
// 可以使用自定义类扩展 MVC功能
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
   //视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 浏览器发送/guo  就会跳转到test页面
        registry.addViewController("/guo").setViewName("test");
    }

    // ViewResolver实现了视图解析器接口的类，我们就可以把它看作视图解析器
    @Bean
    public ViewResolver myViewResolver(){
        return  new MyViewResolver();
    }
    //自定义一个视图解析器MyViewResolver
    public static class MyViewResolver implements ViewResolver {
        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }
}
