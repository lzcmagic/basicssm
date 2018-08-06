package com.lzc.basicssm.service.impl;

import com.lzc.basicssm.bean.DiaryBean;
import com.lzc.basicssm.dao.DiaryDao;
import com.lzc.basicssm.entity.Diary;
import com.lzc.basicssm.entity.DiaryType;
import com.lzc.basicssm.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    private DiaryDao diaryDao;

    @Override
    public List<DiaryType> queryDiarysByUserName(String name) {
        return diaryDao.queryDiarysByUserName(name);
    }

    @Override
    public Diary queryDiaryById(int id) {
        return diaryDao.queryDiaryById(id);
    }

    @Override
    public Integer insertDiary(Diary diary) {
        return diaryDao.insertDiary(diary);
    }
}
