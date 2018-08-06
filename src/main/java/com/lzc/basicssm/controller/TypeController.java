package com.lzc.basicssm.controller;

import com.lzc.basicssm.bean.DiaryNameBean;
import com.lzc.basicssm.bean.base.BaseBean;
import com.lzc.basicssm.entity.DiaryType;
import com.lzc.basicssm.service.DiaryTypeService;
import com.lzc.basicssm.utils.AssembleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TypeController {

    @Autowired
    private DiaryTypeService diaryTypeService;

    @RequestMapping(value = "/insert_type", method = RequestMethod.POST)
    @ResponseBody
    public BaseBean insertType(@RequestBody DiaryType diaryType) throws Exception {
        Integer integer = diaryTypeService.insertType(diaryType.getTypeName(), new Date(), diaryType.getImportantLevel()
                , diaryType.getUserId(), diaryType.getNickName());
        return AssembleResult.assemble(integer>0?integer:null);
    }

    @RequestMapping(value = "/query_name_exist", method = RequestMethod.POST)
    @ResponseBody
    public BaseBean<Boolean> isNameExist(@RequestBody DiaryType diaryType) throws Exception {
        Integer integer = diaryTypeService.selectTypeByName(diaryType.getTypeName());
        BaseBean<Boolean> baseBean = new BaseBean<>();
        if (integer > 0) {
            baseBean.setStatus(0);
            baseBean.setData(true);
        } else {
            baseBean.setStatus(-1);
            baseBean.setData(false);
        }
        return baseBean;
    }

    @RequestMapping(value = "/query_all_type_name")
    @ResponseBody
    public BaseBean<List<DiaryNameBean>> selectAllTypeName(@RequestBody DiaryType diaryType) throws Exception {
        List<DiaryType> diaryTypes = diaryTypeService.selectAllTypeByUserId(diaryType.getUserId());
        List<DiaryNameBean> list=new ArrayList<>();
        BaseBean<List<DiaryNameBean>> bean=new BaseBean<>();
        if (diaryTypes!=null&&diaryTypes.size()>0){
            for (DiaryType diaryType1:diaryTypes){
                list.add(new DiaryNameBean(diaryType1.getId(),diaryType1.getTypeName()));
            }
            return AssembleResult.assemble(list);
        }else{
            return AssembleResult.assemble(null);
        }
    }
}
