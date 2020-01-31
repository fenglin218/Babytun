package com.itlaoqi.babytun.dao;

import com.itlaoqi.babytun.entity.GoodsCover;

import java.util.List;

public interface GoodsCoverDAO {
    public List<GoodsCover> findByGoodsId(Long goodsId);
}
