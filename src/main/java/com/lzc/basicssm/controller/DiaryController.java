package com.lzc.basicssm.controller;

import com.lzc.basicssm.bean.DiaryBean;
import com.lzc.basicssm.bean.base.BaseBean;
import com.lzc.basicssm.entity.Diary;
import com.lzc.basicssm.entity.DiaryType;
import com.lzc.basicssm.entity.UserInfo;
import com.lzc.basicssm.service.DiaryService;
import com.lzc.basicssm.utils.AssembleResult;
import com.lzc.basicssm.utils.DateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class DiaryController {


    @Autowired
    private DiaryService diaryService;

    @RequestMapping(value = "/query_all_types")
    @ResponseBody
    public BaseBean<DiaryBean> queryAllTypes(@RequestBody UserInfo userInfo) throws Exception {

        List<DiaryType> diaryTypes = diaryService.queryDiarysByUserName(userInfo.getNickName());
        BaseBean<DiaryBean> bean = new BaseBean<>();
        if (diaryTypes.size() > 0) {
            bean.setStatus(0);
            DiaryBean diaryBean = new DiaryBean();
            List<DiaryBean.DiaryType> firstChildren = new ArrayList<>();
            for (DiaryType diaryType : diaryTypes) {
                DiaryBean.DiaryType firstChild = new DiaryBean.DiaryType();
                firstChild.setTitle(diaryType.getTypeName());
                List<Diary> diaries = diaryType.getDiaries();
                List<List<Diary>> lists = assembleDiaries(diaries);
                lists.sort(new Comparator<List<Diary>>() {
                    @Override
                    public int compare(List<Diary> o1, List<Diary> o2) {
                        return o1.get(0).getCreateTime().getTime()>o2.get(0).getCreateTime().getTime()?-1:1;
                    }
                });
                firstChild.setListSet(lists);
                firstChildren.add(firstChild);
            }
            diaryBean.setDiaryTypes(firstChildren);
            bean.setData(diaryBean);
        } else {
            bean.setStatus(-1);
        }

        return bean;
    }



    private List<List<Diary>> assembleDiaries(List<Diary> diaries) {
        List<Diary> cloenList = new ArrayList<>(diaries);
        Map<Integer, List<Diary>> map = new HashMap<>();
        for (int i = 0; i < diaries.size(); i++) {
            String date1 = DateFormatUtil.formatDate(diaries.get(i).getCreateTime());
            List<Diary> diaryList = new ArrayList<>();
            for (Diary aCloenList : cloenList) {
                String date2 = DateFormatUtil.formatDate(aCloenList.getCreateTime());
                if (date1.equals(date2)) {
                    diaryList.add(aCloenList);
                }
            }
            map.put(i, diaryList);
        }
        Iterator<Map.Entry<Integer, List<Diary>>> iterator1 = map.entrySet().iterator();
        Set<List<Diary>> diarySet = new HashSet<>();
        while (iterator1.hasNext()) {
            Map.Entry<Integer, List<Diary>> next = iterator1.next();
            diarySet.add(next.getValue());
        }
        return new ArrayList<>(diarySet);
    }

    @RequestMapping(value = "/query_article")
    @ResponseBody
    public BaseBean<Diary> queryDiaryById(@RequestBody Diary diary) throws Exception {
        Diary diary1 = diaryService.queryDiaryById(diary.getId());
        return AssembleResult.assemble(diary1);
    }


    @RequestMapping(value = "/insert_article")
    @ResponseBody
    public BaseBean insertDiary(@RequestBody Diary diary) throws Exception {
        diary.setCreateTime(new Date());
        Integer integer = diaryService.insertDiary(diary);
        return AssembleResult.assemble(integer>0?integer:null);
    }
}
