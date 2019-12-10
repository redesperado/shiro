package com.example.shiro.service;

import com.example.shiro.bean.UserBean;

public interface UserService {

    UserBean loginIn(String name, String password);

    String getRole(String name);

    String getPassword(String name);
}
