package com.lzc.basicssm.service.impl;

import com.lzc.basicssm.entity.Items;
import com.lzc.basicssm.entity.ItemsCustom;
import com.lzc.basicssm.entity.ItemsQueryVo;
import com.lzc.basicssm.dao.ItemsDao;
import com.lzc.basicssm.dao.ItemsMapperCustom;
import com.lzc.basicssm.service.ItemsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {


    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    @Override
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
        return itemsMapperCustom.findItemsList(itemsQueryVo);
    }

    @Autowired
    private ItemsDao itemsDao;

    public ItemsCustom findItemsById(Integer id) throws Exception {
        Items items = itemsDao.selectByPrimaryKey(id);
        //中间对商品信息进行业务处理
        //....
        //返回ItemsCustom
        ItemsCustom itemsCustom = new ItemsCustom();
        //将items的属性值拷贝到itemsCustom
        BeanUtils.copyProperties(items, itemsCustom);

        return itemsCustom;
    }

    public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
        //添加业务校验，通常在service接口对关键参数进行校验
        //校验 id是否为空，如果为空抛出异常

        //更新商品信息使用updateByPrimaryKeyWithBLOBs根据id更新items表中所有字段，包括 大文本类型字段
        //updateByPrimaryKeyWithBLOBs要求必须转入id
        itemsCustom.setId(id);
        itemsDao.updateByPrimaryKeyWithBLOBs(itemsCustom);
    }
}
