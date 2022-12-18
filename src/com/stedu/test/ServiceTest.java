package com.stedu.test;

import com.stedu.bean.Department;
import com.stedu.service.DepartmentService;
import com.stedu.service.impl.DepartmentServiceImpl;
import com.stedu.service.impl.ProjectServiceImpl;
import org.junit.Test;

import java.util.List;

public class ServiceTest {
    @Test
    public void test1() {
        ProjectServiceImpl projectService = new ProjectServiceImpl();

        projectService.findAll().forEach(System.out::println);
    }

    @Test
    public void test2() {
        DepartmentService departmentService = new DepartmentServiceImpl();
        List<Department> allWithEmployee = departmentService.findAllWithEmployee();
        allWithEmployee.forEach(System.out::println);
    }
}
