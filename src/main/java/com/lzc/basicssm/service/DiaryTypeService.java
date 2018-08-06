package com.lzc.basicssm.service;

import com.lzc.basicssm.bean.DiaryBean;
import com.lzc.basicssm.entity.DiaryType;
import org.omg.CORBA.INTERNAL;

import java.util.Date;
import java.util.List;

public interface DiaryTypeService {
    Integer insertType(String typeName, Date createTime, int importLevel, int userId, String nickName) throws Exception;

    Integer selectTypeByName(String typeName) throws Exception;

    List<DiaryType> selectAllTypeByUserId(int userId) throws Exception;
}
