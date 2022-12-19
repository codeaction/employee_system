package com.stedu.test;

import com.stedu.bean.Department;
import com.stedu.bean.Project;
import com.stedu.service.DepartmentService;
import com.stedu.service.ProjectService;
import com.stedu.service.impl.DepartmentServiceImpl;
import com.stedu.service.impl.ProjectServiceImpl;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
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
        allWithEmployee.forEach(item -> System.out.println(item.getDname()));
    }

    @Test
    public void test3() {
        ProjectService projectService = new ProjectServiceImpl();
        Date start = new Date(2021, 10, 15);
        Date end = new Date(2021, 12, 15);
        Project project = new Project("test111", start, end, 0,"test");
        Integer[] eids = {4};

        projectService.add(project, Arrays.asList(eids));
    }
}
