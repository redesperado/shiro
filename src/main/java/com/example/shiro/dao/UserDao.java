package com.example.shiro.dao;

import com.example.shiro.bean.UserBean;

public interface UserDao {

    UserBean getInfo(String name, String password);

    String getRole(String name);

    String getPassword(String name);
}
