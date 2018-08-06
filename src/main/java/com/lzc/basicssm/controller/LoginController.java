package com.lzc.basicssm.controller;

import com.lzc.basicssm.bean.LoginSuccessBean;
import com.lzc.basicssm.bean.base.BaseBean;
import com.lzc.basicssm.entity.LoginUser;
import com.lzc.basicssm.entity.LoginUserExample;
import com.lzc.basicssm.entity.UserInfo;
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
    public BaseBean doLogin(@RequestBody LoginUser user) throws Exception {


        LoginUser resultUser;
//        if (RedisUtil.getInstance().get("user")!=null){
//            resultUser= (LoginUser) RedisUtil.getInstance().get("user");
//        }else{
            resultUser = userService.findUserByUserName(user.getUsername());
//        }

        BaseBean<LoginSuccessBean> bean = new BaseBean<>();
        if (resultUser != null) {
            if (resultUser.getPassword().equals(user.getPassword())) {
                //login success
//                RedisUtil.getInstance().set("user", resultUser);
                bean.setStatus(0);
                bean.setData(new LoginSuccessBean(resultUser.getUserInfo().getId(), user.getUsername(),resultUser.getUserInfo().getNickName()));
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

    @RequestMapping(value = "/query_user_info" ,method = RequestMethod.POST)
    @ResponseBody
    public BaseBean<UserInfo> queryInfo(@RequestBody LoginUser user) throws Exception {
        UserInfo userInfo=userService.findInfoByUserName(user.getUsername());
        BaseBean<UserInfo> bean=new BaseBean<>();
            bean.setData(userInfo);
        if (userInfo!=null){
            bean.setStatus(0);//成功
        }else{
            bean.setStatus(-1);//失败
        }
        return bean;
    }

}
