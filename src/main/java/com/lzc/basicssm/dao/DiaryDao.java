package com.lzc.basicssm.dao;

import com.lzc.basicssm.entity.Diary;
import com.lzc.basicssm.entity.DiaryType;

import java.util.List;

public interface DiaryDao {

    List<DiaryType> queryDiarysByUserName(String name);

    Diary queryDiaryById(int id);

    Integer insertDiary(Diary diary);
}
