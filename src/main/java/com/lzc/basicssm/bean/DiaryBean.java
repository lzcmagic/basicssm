package com.lzc.basicssm.bean;

import com.lzc.basicssm.entity.Diary;
import com.lzc.basicssm.entity.DiaryType;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class DiaryBean {


    /*
          [{
	        "title": "",
	        "subTitle": [{
		        "title": "",
		        "articles": []
	        }]
          }]
     */

    private List<DiaryType> diaryTypes;

    public List<DiaryType> getDiaryTypes() {
        return diaryTypes;
    }

    public void setDiaryTypes(List<DiaryType> diaryTypes) {
        this.diaryTypes = diaryTypes;
    }

    /**
     * 一级菜单
     */
    public static class DiaryType{
        private String title;
        private List<List<Diary>> listSet;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<List<Diary>> getListSet() {
            return listSet;
        }

        public void setListSet(List<List<Diary>> listSet) {
            this.listSet = listSet;
        }

//        private List<DiaryDetail> diaryDetails;
//
//
//
//        public List<DiaryDetail> getDiaryDetails() {
//            return diaryDetails;
//        }
//
//        public void setDiaryDetails(List<DiaryDetail> diaryDetails) {
//            this.diaryDetails = diaryDetails;
//        }
    }

    /**
     * 二级菜单
     */
    public static class DiaryDetail{
        private Date createTitle;
        private String title;
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getCreateTitle() {
            return createTitle;
        }

        public void setCreateTitle(Date createTitle) {
            this.createTitle = createTitle;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class DiaryTitle{
        private String title;
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

}
