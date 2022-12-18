package com.stedu.dao;

import com.stedu.bean.Employee;
import com.stedu.bean.EmployeeVo;
import com.stedu.bean.Page;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    //查询最大的员工编号
    String maxEno() throws SQLException;
    //添加员工
    void add(Employee employee) throws SQLException;
    //修改员工状态
    int chgEstate(Integer eid, Integer estate);
    //修改员工
    int update(Employee employee);
    //查询员工个数
    long count(String searchName);
    //分页查询
    Page<EmployeeVo> findByPage(Page<EmployeeVo> page, String searchName);
    //根据部门ID查询员工
    List<Employee> findByDid(Integer did);
    //根据员工编号查询员工
    Employee findById(Integer eid);
    //根据项目编号查询员工
    List<Employee> findByProjectId(Integer pid);
}
