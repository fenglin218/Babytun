package com.itlaoqi.babytun.dao;

import com.itlaoqi.babytun.entity.GoodsDetail;
import com.itlaoqi.babytun.entity.GoodsParam;

import java.util.List;

public interface GoodsParamDAO {
    public List<GoodsParam> findByGoodsId(Long goodsId);
}
