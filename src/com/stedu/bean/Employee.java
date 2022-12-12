package com.stedu.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 员工表
 * @TableName employee
 */
public class Employee implements Serializable {
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Employee other = (Employee) that;
        return (this.getEid() == null ? other.getEid() == null : this.getEid().equals(other.getEid()))
            && (this.getEno() == null ? other.getEno() == null : this.getEno().equals(other.getEno()))
            && (this.getEname() == null ? other.getEname() == null : this.getEname().equals(other.getEname()))
            && (this.getEage() == null ? other.getEage() == null : this.getEage().equals(other.getEage()))
            && (this.getEgender() == null ? other.getEgender() == null : this.getEgender().equals(other.getEgender()))
            && (this.getEjob() == null ? other.getEjob() == null : this.getEjob().equals(other.getEjob()))
            && (this.getEentrydate() == null ? other.getEentrydate() == null : this.getEentrydate().equals(other.getEentrydate()))
            && (this.getEsalary() == null ? other.getEsalary() == null : this.getEsalary().equals(other.getEsalary()))
            && (this.getEstate() == null ? other.getEstate() == null : this.getEstate().equals(other.getEstate()))
            && (this.getDid() == null ? other.getDid() == null : this.getDid().equals(other.getDid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEid() == null) ? 0 : getEid().hashCode());
        result = prime * result + ((getEno() == null) ? 0 : getEno().hashCode());
        result = prime * result + ((getEname() == null) ? 0 : getEname().hashCode());
        result = prime * result + ((getEage() == null) ? 0 : getEage().hashCode());
        result = prime * result + ((getEgender() == null) ? 0 : getEgender().hashCode());
        result = prime * result + ((getEjob() == null) ? 0 : getEjob().hashCode());
        result = prime * result + ((getEentrydate() == null) ? 0 : getEentrydate().hashCode());
        result = prime * result + ((getEsalary() == null) ? 0 : getEsalary().hashCode());
        result = prime * result + ((getEstate() == null) ? 0 : getEstate().hashCode());
        result = prime * result + ((getDid() == null) ? 0 : getDid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eid=").append(eid);
        sb.append(", eno=").append(eno);
        sb.append(", ename=").append(ename);
        sb.append(", eage=").append(eage);
        sb.append(", egender=").append(egender);
        sb.append(", ejob=").append(ejob);
        sb.append(", eentrydate=").append(eentrydate);
        sb.append(", esalary=").append(esalary);
        sb.append(", estate=").append(estate);
        sb.append(", did=").append(did);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}