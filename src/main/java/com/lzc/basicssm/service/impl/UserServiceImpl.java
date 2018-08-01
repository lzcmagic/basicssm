package com.lzc.basicssm.service.impl;

import com.lzc.basicssm.dao.UserDao;
import com.lzc.basicssm.entity.User;
import com.lzc.basicssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserByUserName(String username) throws Exception {
        return userDao.selectByUserName(username);
    }
}
