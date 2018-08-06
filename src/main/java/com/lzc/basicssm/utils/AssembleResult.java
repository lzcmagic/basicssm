package com.lzc.basicssm.utils;

import com.lzc.basicssm.bean.base.BaseBean;

public class AssembleResult {

    public static <T>BaseBean<T> assemble(T t){
        BaseBean<T> baseBean=new BaseBean<>();
        baseBean.setData(t);
        if (t!=null){
            baseBean.setStatus(0);
        }else{
            baseBean.setStatus(-1);
        }
        return baseBean;
    }
}
