package com.stedu.dao;

import com.stedu.bean.Admin;

public interface AdminDao {
    Admin findByUsernameAndPassword(String username, String password);
}
