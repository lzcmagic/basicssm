package com.lzc.basicssm.dao;

import com.lzc.basicssm.entity.ItemsCustom;
import com.lzc.basicssm.entity.ItemsQueryVo;

import java.util.List;

public interface ItemsMapperCustom {
    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}
