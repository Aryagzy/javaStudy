package com.example.demo.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
import java.util.Map;

/*
  @ConfigurationProperties作用：
  将配置文件中配置的每一个属性的值，映射到这个组件中
  告诉SpringBoot将本类中的所有属性和配置文件中相关配置进行绑定
  参数prefix = "person"：将配置文件中的person下面的所有属性一一对应
  只有这个组件是容器中的组件，才能使用容器提供的@ConfigurationProperties功能
*/
@Component // 注册Bean
//加载yaml配置文件
@ConfigurationProperties(prefix = "person")
//加载指定的配置文件
//@PropertySource(value = "classpath:qingjiang.propterties")
@Validated //数据校验
public class Person {
    //直接使用@Value
    @Value("${person.name}")  //从配置文件中取值
    private String name;
    @Value("#{11*2}")   //#{SPEL} spring表达式
    private  Integer age;
    @Value("true")     //字面量
    private  Boolean happy;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dos;

    public Person() {
    }

    public Person(String name, Integer age, Boolean happy, Date birth, Map<String, Object> maps, List<Object> lists, Dog dos) {
        this.name = name;
        this.age = age;
        this.happy = happy;
        this.birth = birth;
        this.maps = maps;
        this.lists = lists;
        this.dos = dos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getHappy() {
        return happy;
    }

    public void setHappy(Boolean happy) {
        this.happy = happy;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDos() {
        return dos;
    }

    public void setDos(Dog dos) {
        this.dos = dos;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", happy=" + happy +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dos=" + dos +
                '}';
    }
}
