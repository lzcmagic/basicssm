package com.lzc.basicssm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoginUserExample extends LoginUser{

    private UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}