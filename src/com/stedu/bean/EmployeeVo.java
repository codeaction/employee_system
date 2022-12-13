package com.stedu.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * 员工表
 * @TableName employee
 */
public class EmployeeVo implements Serializable {
    /**
     * 主键
     */
    private Long eid;

    /**
     * 工号
     */
    private String eno;

    /**
     * 姓名
     */
    private String ename;

    /**
     * 年龄
     */
    private Integer eage;

    /**
     * 性别
     */
    private String egender;

    /**
     * 工种
     */
    private String ejob;

    /**
     * 入职时间
     */
    @JsonFormat(pattern = "yyyy年MM月dd日")
    private Date eentrydate;

    /**
     * 基本薪资
     */
    private BigDecimal esalary;

    /**
     * 在职状态(1.在职 2.离职)
     */
    private Integer estate;

    /**
     * 部门编号
     */
    private Integer did;
    /**
     * 部门名称
     */
    private String dname;

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    public Long getEid() {
        return eid;
    }

    /**
     * 主键
     */
    public void setEid(Long eid) {
        this.eid = eid;
    }

    /**
     * 工号
     */
    public String getEno() {
        return eno;
    }

    /**
     * 工号
     */
    public void setEno(String eno) {
        this.eno = eno;
    }

    /**
     * 姓名
     */
    public String getEname() {
        return ename;
    }

    /**
     * 姓名
     */
    public void setEname(String ename) {
        this.ename = ename;
    }

    /**
     * 年龄
     */
    public Integer getEage() {
        return eage;
    }

    /**
     * 年龄
     */
    public void setEage(Integer eage) {
        this.eage = eage;
    }

    /**
     * 性别
     */
    public String getEgender() {
        return egender;
    }

    /**
     * 性别
     */
    public void setEgender(String egender) {
        this.egender = egender;
    }

    /**
     * 工种
     */
    public String getEjob() {
        return ejob;
    }

    /**
     * 工种
     */
    public void setEjob(String ejob) {
        this.ejob = ejob;
    }

    /**
     * 入职时间
     */
    public Date getEentrydate() {
        return eentrydate;
    }

    /**
     * 入职时间
     */
    public void setEentrydate(Date eentrydate) {
        this.eentrydate = eentrydate;
    }

    /**
     * 基本薪资
     */
    public BigDecimal getEsalary() {
        return esalary;
    }

    /**
     * 基本薪资
     */
    public void setEsalary(BigDecimal esalary) {
        this.esalary = esalary;
    }

    /**
     * 在职状态(1.在职 2.离职)
     */
    public Integer getEstate() {
        return estate;
    }

    /**
     * 在职状态(1.在职 2.离职)
     */
    public void setEstate(Integer estate) {
        this.estate = estate;
    }

    /**
     * 部门编号
     */
    public Integer getDid() {
        return did;
    }

    /**
     * 部门编号
     */
    public void setDid(Integer did) {
        this.did = did;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDname() {
        return dname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeVo that = (EmployeeVo) o;
        return Objects.equals(eid, that.eid) && Objects.equals(eno, that.eno) && Objects.equals(ename, that.ename) && Objects.equals(eage, that.eage) && Objects.equals(egender, that.egender) && Objects.equals(ejob, that.ejob) && Objects.equals(eentrydate, that.eentrydate) && Objects.equals(esalary, that.esalary) && Objects.equals(estate, that.estate) && Objects.equals(did, that.did) && Objects.equals(dname, that.dname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eid, eno, ename, eage, egender, ejob, eentrydate, esalary, estate, did, dname);
    }

    @Override
    public String toString() {
        return "EmployeeVo{" +
                "eid=" + eid +
                ", eno='" + eno + '\'' +
                ", ename='" + ename + '\'' +
                ", eage=" + eage +
                ", egender='" + egender + '\'' +
                ", ejob='" + ejob + '\'' +
                ", eentrydate=" + eentrydate +
                ", esalary=" + esalary +
                ", estate=" + estate +
                ", did=" + did +
                ", dname='" + dname + '\'' +
                '}';
    }
}