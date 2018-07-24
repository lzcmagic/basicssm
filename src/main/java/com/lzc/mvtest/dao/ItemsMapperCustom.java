package com.lzc.mvtest.dao;

import com.lzc.mvtest.domain.ItemsCustom;
import com.lzc.mvtest.domain.ItemsQueryVo;

import java.util.List;

public interface ItemsMapperCustom {
    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}
