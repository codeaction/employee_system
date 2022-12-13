package com.stedu.test;

import com.stedu.bean.Page;
import com.stedu.dao.EmployeeDao;
import com.stedu.dao.impl.EmployeeDaoImpl;
import com.stedu.utils.PageUtil;
import org.junit.Test;

import java.util.Arrays;

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
}
