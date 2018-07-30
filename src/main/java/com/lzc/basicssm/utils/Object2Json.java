package com.lzc.basicssm.utils;

import com.alibaba.fastjson.JSON;
import com.lzc.basicssm.bean.base.BaseBean;

public class Object2Json {

    /*
        {
        status: //integer
        data:{] object

        }
     */
    public static <T> String toJson(BaseBean<T> value){
        return JSON.toJSONString(value);
    }
}
