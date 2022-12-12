package com.stedu.service;

import com.stedu.bean.Admin;

public interface AdminService {
    Admin login(String username, String password);
}
