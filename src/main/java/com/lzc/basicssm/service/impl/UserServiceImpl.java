package com.lzc.basicssm.service.impl;

import com.lzc.basicssm.dao.UserDao;
import com.lzc.basicssm.entity.LoginUser;
import com.lzc.basicssm.entity.LoginUserExample;
import com.lzc.basicssm.entity.UserInfo;
import com.lzc.basicssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public LoginUser findUserByUserName(String username) {
        return userDao.selectByUserName(username);
    }

    @Override
    public UserInfo findInfoByUserName(String name) {
        return userDao.selectInfoByName(name);
    }
}
