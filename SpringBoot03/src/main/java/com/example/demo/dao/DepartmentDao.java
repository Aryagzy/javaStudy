package com.example.demo.dao;

import com.example.demo.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// 部门dao
@Repository
public class DepartmentDao {
    // 模拟数据库中的数据
    private static Map<Integer, Department> departments = null;

    static {
        //创建一个部门表
        departments = new HashMap<Integer, Department>();

        departments.put(101, new Department(101, "教学部"));
        departments.put(102, new Department(102, "市场部"));
        departments.put(103, new Department(103, "后勤部"));
        departments.put(104, new Department(104, "学杂部"));
        departments.put(105, new Department(105, "运营部"));
    }
    // 对数据库的操作 增删改查
    //1.查询所有部门信息
    public Collection<Department> getDepartments(){
        return departments.values();
    }
    // 2.通过id得到部门
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}
