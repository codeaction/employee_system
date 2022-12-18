package com.stedu.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 
 * @TableName project
 */
public class Project implements Serializable {
    /**
     * 主键
     */
    private Integer pid;

    /**
     * 项目名
     */
    private String pname;

    /**
     * 项目开始时间
     */
    @JsonFormat(pattern = "yyyy年MM月dd日")
    private Date pstart;

    /**
     * 项目结束时间
     */
    @JsonFormat(pattern = "yyyy年MM月dd日")
    private Date pend;

    /**
     * 项目进度(0-100)
     */
    private Integer pprogress;

    /**
     * 项目描述
     */
    private String pdescription;

    /**
     * 项目人员
     */
    private List<Employee> emps;

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 主键
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 项目名
     */
    public String getPname() {
        return pname;
    }

    /**
     * 项目名
     */
    public void setPname(String pname) {
        this.pname = pname;
    }

    /**
     * 项目开始时间
     */
    public Date getPstart() {
        return pstart;
    }

    /**
     * 项目开始时间
     */
    public void setPstart(Date pstart) {
        this.pstart = pstart;
    }

    /**
     * 项目结束时间
     */
    public Date getPend() {
        return pend;
    }

    /**
     * 项目结束时间
     */
    public void setPend(Date pend) {
        this.pend = pend;
    }

    /**
     * 项目进度(0-100)
     */
    public Integer getPprogress() {
        return pprogress;
    }

    /**
     * 项目进度(0-100)
     */
    public void setPprogress(Integer pprogress) {
        this.pprogress = pprogress;
    }

    /**
     * 项目描述
     */
    public String getPdescription() {
        return pdescription;
    }

    /**
     * 项目描述
     */
    public void setPdescription(String pdescription) {
        this.pdescription = pdescription;
    }

    /**
     * 项目人员
     */
    public List<Employee> getEmps() {
        return emps;
    }

    /**
     * 项目人员
     */
    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(pid, project.pid) && Objects.equals(pname, project.pname) && Objects.equals(pstart, project.pstart) && Objects.equals(pend, project.pend) && Objects.equals(pprogress, project.pprogress) && Objects.equals(pdescription, project.pdescription) && Objects.equals(emps, project.emps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, pname, pstart, pend, pprogress, pdescription, emps);
    }

    @Override
    public String toString() {
        return "Project{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pstart=" + pstart +
                ", pend=" + pend +
                ", pprogress=" + pprogress +
                ", pdescription='" + pdescription + '\'' +
                ", emps=" + emps +
                '}';
    }
}