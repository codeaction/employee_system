package com.stedu.dao.impl;

import com.stedu.bean.Employee;
import com.stedu.bean.EmployeeVo;
import com.stedu.bean.Page;
import com.stedu.dao.EmployeeDao;
import com.stedu.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public String maxEno() throws SQLException {
        String sql = "SELECT MAX(`eno`) FROM `employee`";
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        return qr.query(JdbcUtil.getConnection(), sql, new ScalarHandler<String>());
    }

    @Override
    public void add(Employee e) throws SQLException {
        String sql = "insert into `employee`(`eno`, `ename`, `eage`, `egender`, `ejob`, `eentrydate`, `esalary`, `estate`, `did`) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] params = {e.getEno(), e.getEname(), e.getEage(), e.getEgender(), e.getEjob(), new Date(e.getEentrydate().getTime()), e.getEsalary(), e.getEstate(), e.getDid()};

        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        qr.update(JdbcUtil.getConnection(), sql, params);
    }

    @Override
    public int chgEstate(Integer eid, Integer estate) {
        String sql = "update `employee` set `estate`=? where `eid`=?";
        Object[] params = {estate, eid};
        int result = 0;

        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());

        try {
            result = qr.update(sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    @Override
    public int update(Employee e) {
        String sql = "update `employee` set `ename`=?, `eage`=?, `egender`=?, `ejob`=?, `eentrydate`=?, `esalary`=?, `did`=? where `eid`=?";
        Object[] params = {e.getEname(), e.getEage(), e.getEgender(), e.getEjob(), new Date(e.getEentrydate().getTime()), e.getEsalary(), e.getDid(), e.getEid()};
        int result = 0;

        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        try {
            result = qr.update(JdbcUtil.getConnection(), sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    @Override
    public long count(String searchName) {
        String sql = "select count(1) from `employee` where 1=1";
        Object[] params = null;
        if(!searchName.equals("") && !(searchName == null)) {
            sql = sql + " and `ename` like ?";
            params = new Object[]{"%" + searchName + "%"};
        }

        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        long count = 0;

        try {
            count = qr.query(sql, new ScalarHandler<Long>(), params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return count;
    }

    @Override
    public Page<EmployeeVo> findByPage(Page<EmployeeVo> page, String searchName) {
        String sql = "select e.*, d.dname from `employee` e, `department` d where e.did=d.did and 1=1";
        ArrayList<Object> objectList = new ArrayList<>();
        if(!searchName.equals("") && !(searchName == null)) {
            sql = sql + " and `ename` like ?";
            objectList.add("%" + searchName + "%");
        }
        sql = sql + " limit ?, ?";

        objectList.add(page.getBeginIndex());
        objectList.add(page.getEveryPage());
        List<EmployeeVo> list = null;

        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        try {
            list = qr.query(sql, new BeanListHandler<EmployeeVo>(EmployeeVo.class), objectList.toArray());
            page.setList(list);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return page;
    }

    @Override
    public List<Employee> findByDid(Integer did) {
        String sql = "select * from `employee` where `did`=?";
        Object[] params = {did};
        List<Employee> list = null;

        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        try {
            list = qr.query(sql, new BeanListHandler<Employee>(Employee.class), params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public Employee findById(Integer eid) {
        String sql = "select * from `employee` where `eid`=?";
        Object[] params = {eid};
        Employee employee = null;

        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        try {
            employee = qr.query(sql, new BeanHandler<Employee>(Employee.class), params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return employee;
    }
}
