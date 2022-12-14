package com.stedu.test;

import com.stedu.bean.Employee;
import com.stedu.bean.Page;
import com.stedu.dao.EmployeeDao;
import com.stedu.dao.impl.EmployeeDaoImpl;
import com.stedu.service.impl.EmployeeServiceImpl;
import com.stedu.utils.JdbcUtil;
import com.stedu.utils.PageUtil;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;

public class DaoTest {
    @Test
    public void test1() {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        System.out.println(employeeDao.count());
    }

    @Test
    public void test2() {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        Page page = PageUtil.createPage(21, 21, 1);
        Page p = employeeDao.findByPage(page);
        p.getList().stream().forEach(System.out::println);

        System.out.println(Arrays.toString(page.getNavigation()));
    }

    @Test
    public void test3() {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        try {
            JdbcUtil.beginTransaction();
            String i = employeeDao.maxEno();
            System.out.println(i);
            JdbcUtil.commitTransaction();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                JdbcUtil.rollbackTransaction();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test4() {
        Employee e = new Employee();
        e.setEname("aaaa1");
        e.setEage(20);
        e.setEgender("男");
        e.setEjob("架构师");
        e.setEentrydate(new Date());
        e.setEsalary(BigDecimal.valueOf(20000.00));
        e.setEstate(1);
        e.setDid(1);

        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        employeeService.add(e);
    }
}
