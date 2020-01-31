package com.itlaoqi.babytun.dao;

import com.itlaoqi.babytun.entity.Evaluate;
import com.itlaoqi.babytun.entity.Goods;

import java.util.List;

public interface EvaluateDAO {
    public List<Evaluate> findByGoodsId(Long goodsId);
}
