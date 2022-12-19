package com.stedu.dao;

import com.stedu.bean.Project;

import java.sql.SQLException;
import java.util.List;

public interface ProjectDao {
    List<Project> findAll();
    Long add(Project project) throws SQLException;
}
