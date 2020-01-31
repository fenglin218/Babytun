package com.itlaoqi.babytun.dao;

import com.itlaoqi.babytun.entity.GoodsCover;
import com.itlaoqi.babytun.entity.GoodsDetail;

import java.util.List;

public interface GoodsDetailDAO {
    public List<GoodsDetail> findByGoodsId(Long goodsId);
}
