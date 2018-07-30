package com.lzc.basicssm.service.impl;

import com.lzc.basicssm.dao.UserMapper;
import com.lzc.basicssm.domain.User;
import com.lzc.basicssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByUserName(String username) throws Exception {
        return userMapper.selectByUserName(username);
    }
}
