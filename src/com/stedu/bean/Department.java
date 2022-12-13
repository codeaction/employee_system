package com.stedu.bean;

import java.io.Serializable;

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
        Department other = (Department) that;
        return (this.getDid() == null ? other.getDid() == null : this.getDid().equals(other.getDid()))
            && (this.getDname() == null ? other.getDname() == null : this.getDname().equals(other.getDname()))
            && (this.getDlocation() == null ? other.getDlocation() == null : this.getDlocation().equals(other.getDlocation()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDid() == null) ? 0 : getDid().hashCode());
        result = prime * result + ((getDname() == null) ? 0 : getDname().hashCode());
        result = prime * result + ((getDlocation() == null) ? 0 : getDlocation().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", did=").append(did);
        sb.append(", dname=").append(dname);
        sb.append(", dlocation=").append(dlocation);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}