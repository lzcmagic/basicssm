package com.lzc.basicssm.service;

import com.lzc.basicssm.domain.User;

public interface UserService {

    //查询user信息
    User findUserByUserName(String name) throws Exception;
}