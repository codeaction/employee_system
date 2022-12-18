package com.stedu.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * 部门表
 * @TableName department
 */
public class Department implements Serializable {
    /**
     * 主键
     */
    private Integer did;

    /**
     * 部门名称
     */
    private String dname;

    /**
     * 部门位置
     */
    private String dlocation;

    /**
    * 部门员工
    */
    private List<Employee> emps;

    private static final long serialVersionUID = 1L;

    public Department() {

    }

    public Department(String dname, String dlocation) {
        this.dname = dname;
        this.dlocation = dlocation;
    }

    public Department(Integer did, String dname, String dlocation) {
        this.did = did;
        this.dname = dname;
        this.dlocation = dlocation;
    }

    /**
     * 主键
     */
    public Integer getDid() {
        return did;
    }

    /**
     * 主键
     */
    public void setDid(Integer did) {
        this.did = did;
    }

    /**
     * 部门名称
     */
    public String getDname() {
        return dname;
    }

    /**
     * 部门名称
     */
    public void setDname(String dname) {
        this.dname = dname;
    }

    /**
     * 部门位置
     */
    public String getDlocation() {
        return dlocation;
    }

    /**
     * 部门位置
     */
    public void setDlocation(String dlocation) {
        this.dlocation = dlocation;
    }

    /**
     * 部门员工
     */
    public List<Employee> getEmps() {
        return emps;
    }

    /**
     * 部门员工
     */
    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(did, that.did) && Objects.equals(dname, that.dname) && Objects.equals(dlocation, that.dlocation) && Objects.equals(emps, that.emps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(did, dname, dlocation, emps);
    }

    @Override
    public String toString() {
        return "Department{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", dlocation='" + dlocation + '\'' +
                ", emps=" + emps +
                '}';
    }
}