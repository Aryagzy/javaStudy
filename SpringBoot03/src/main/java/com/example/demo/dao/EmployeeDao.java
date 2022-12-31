package com.example.demo.dao;

import com.example.demo.pojo.Department;
import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// 员工Dao
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;
    // 员工所属部门，关联外键
    @Autowired
    private DepartmentDao departmentDao;

    static {
        // 创建一个员工表
        employees = new HashMap<Integer, Employee>();

        employees.put(1001, new Employee(1001, "A", "1111@qq.com", 0, new Department(101, "教学部")));
        employees.put(1002, new Employee(1002, "B", "2111@qq.com", 1, new Department(102, "市场部")));
        employees.put(1003, new Employee(1003, "C", "3111@qq.com", 0, new Department(103, "后勤部")));
        employees.put(1004, new Employee(1004, "D", "4111@qq.com", 1, new Department(104, "学杂部")));
        employees.put(1005, new Employee(1005, "E", "5111@qq.com", 0, new Department(105, "运营部")));
    }

    // 对数据增删改查
    //1.增加员工
    // 主键自增
    private static Integer initId = 1006;

    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }
    //2.查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }
    //3.通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    //4.删除员工通过id
    public void delete(Integer id){
        employees.remove(id);
    }
}


