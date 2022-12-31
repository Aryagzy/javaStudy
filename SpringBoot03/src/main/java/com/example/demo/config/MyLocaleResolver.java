package com.example.demo.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import java.util.Locale;
// 自定义组件LocaleResolver
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 解析请求
        // 获取请求中的语言参数
        String language = request.getParameter("lan");
        // 如果没有就使用默认的
        Locale locale = Locale.getDefault();
        // 链接携带了参数
        if(!StringUtils.isEmpty(language)){
            //en_US
           String[] splits = language.split("_");
           //地区，国家
            locale = new Locale(splits[0],splits[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
