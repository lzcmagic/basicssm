package com.lzc.basicssm.dao;

import com.lzc.basicssm.entity.DiaryType;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface DiaryTypeDao {

    Integer insertType(@Param("type_name") String type_name,
                       @Param("createTime")Date createTime,
                       @Param("importantLevel")int importantLevel,
                       @Param("userId")int userId,
                       @Param("nickName")String nickName);

    Integer selectTypeByName(String name);

    List<DiaryType> selectAllTypeByUserId(int userId);
}
