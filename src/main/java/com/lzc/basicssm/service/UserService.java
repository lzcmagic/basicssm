package com.lzc.basicssm.service;

import com.lzc.basicssm.entity.LoginUser;
import com.lzc.basicssm.entity.LoginUserExample;
import com.lzc.basicssm.entity.UserInfo;

public interface UserService {

    //查询user信息
    LoginUser findUserByUserName(String name) throws Exception;

    UserInfo findInfoByUserName(String name) throws Exception;
}
