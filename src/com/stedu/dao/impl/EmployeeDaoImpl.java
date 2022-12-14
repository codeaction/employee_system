package com.stedu.dao.impl;

import com.stedu.bean.Employee;
import com.stedu.bean.EmployeeVo;
import com.stedu.bean.Page;
import com.stedu.dao.EmployeeDao;
import com.stedu.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Date;
import java.sql.SQLException;
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
    public long count() {
        String sql = "select count(1) from `employee`";
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        long count = 0;

        try {
            count = qr.query(sql, new ScalarHandler<Long>());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return count;
    }

    @Override
    public Page<EmployeeVo> findByPage(Page<EmployeeVo> page) {
        String sql = "select e.*, d.dname from `employee` e, `department` d where e.did=d.did  limit ?, ?";
        Object[] params = {page.getBeginIndex(), page.getEveryPage()};
        List<EmployeeVo> list = null;

        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        try {
            list = qr.query(sql, new BeanListHandler<EmployeeVo>(EmployeeVo.class), params);
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
}
