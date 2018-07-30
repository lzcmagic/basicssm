package com.lzc.basicssm.dao;

import com.lzc.basicssm.domain.ItemsCustom;
import com.lzc.basicssm.domain.ItemsQueryVo;

import java.util.List;

public interface ItemsMapperCustom {
    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}
