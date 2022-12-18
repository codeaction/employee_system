package com.stedu.service.impl;

import com.stedu.bean.Admin;
import com.stedu.dao.AdminDao;
import com.stedu.dao.impl.AdminDaoImpl;
import com.stedu.service.AdminService;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();

    @Override
    public Admin login(String username, String password) {
        return adminDao.findByUsernameAndPassword(username, password);
    }

    @Override
    public void chgpwd(String id, String pwd) {
        adminDao.chgpwd(id, pwd);
    }
}
