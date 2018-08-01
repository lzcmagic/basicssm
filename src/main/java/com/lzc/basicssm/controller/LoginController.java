package com.lzc.basicssm.controller;

import com.lzc.basicssm.bean.base.BaseBean;
import com.lzc.basicssm.entity.User;
import com.lzc.basicssm.service.UserService;
import com.lzc.basicssm.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    @ResponseBody
    public BaseBean doLogin(@RequestBody User user) throws Exception {


        User resultUser;
        if (RedisUtil.getInstance().get("user")!=null){
            resultUser= (User) RedisUtil.getInstance().get("user");
        }else{
            resultUser = userService.findUserByUserName(user.getUsername());
        }

        BaseBean<User> bean = new BaseBean<>();
        if (resultUser != null) {
            if (resultUser.getPassword().equals(user.getPassword())) {
                //login success
                RedisUtil.getInstance().set("user", resultUser);
                bean.setStatus(0);
                bean.setData(resultUser);
            } else {
                //pwd wrong
                bean.setStatus(1);
                bean.setData(null);
            }
        } else {
            //没有找到用户名
            bean.setStatus(-1);
            bean.setData(null);
        }
        logger.info("bean: " + bean.toString());
        return bean;
    }
}
