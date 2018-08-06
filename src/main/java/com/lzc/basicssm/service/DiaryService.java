package com.lzc.basicssm.service;

import com.lzc.basicssm.entity.Diary;
import com.lzc.basicssm.entity.DiaryType;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface DiaryService {

    List<DiaryType> queryDiarysByUserName(String name) throws Exception;

    Diary queryDiaryById(int id) throws Exception;

    Integer insertDiary(Diary diary) throws Exception;
}
