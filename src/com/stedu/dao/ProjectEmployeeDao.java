package com.stedu.dao;

import java.sql.SQLException;

public interface ProjectEmployeeDao {
    void add(Integer pid, Integer eid) throws SQLException;
    void del(Integer pid) throws SQLException;
}
