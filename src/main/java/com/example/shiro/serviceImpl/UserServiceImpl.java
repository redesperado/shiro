package com.example.shiro.serviceImpl;

import com.example.shiro.bean.UserBean;
import com.example.shiro.dao.UserDao;
import com.example.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public UserBean loginIn(String name, String password) {
        return userDao.getInfo(name,password);
    }

    @Override
    public String getRole(String name) {
        return userDao.getRole(name);
    }

    @Override
    public String getPassword(String name) {
        return userDao.getPassword(name);
    }

}
