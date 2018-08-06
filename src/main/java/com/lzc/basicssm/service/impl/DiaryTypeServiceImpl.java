package com.lzc.basicssm.service.impl;

import com.lzc.basicssm.dao.DiaryTypeDao;
import com.lzc.basicssm.entity.DiaryType;
import com.lzc.basicssm.service.DiaryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DiaryTypeServiceImpl implements DiaryTypeService {

    @Autowired
    private DiaryTypeDao diaryTypeDao;
    @Override
    public Integer insertType(String type_name, Date createTime, int importLevel, int userId, String nickName) {
        return diaryTypeDao.insertType(type_name,createTime,importLevel,userId,nickName);
    }

    @Override
    public Integer selectTypeByName(String typeName) {
        return diaryTypeDao.selectTypeByName(typeName);
    }

    @Override
    public List<DiaryType> selectAllTypeByUserId(int userId) {
        return diaryTypeDao.selectAllTypeByUserId(userId);
    }
}
