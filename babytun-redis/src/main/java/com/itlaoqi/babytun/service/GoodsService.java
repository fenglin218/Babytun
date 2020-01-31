package com.itlaoqi.babytun.service;

import com.itlaoqi.babytun.dao.GoodsCoverDAO;
import com.itlaoqi.babytun.dao.GoodsDAO;
import com.itlaoqi.babytun.dao.GoodsDetailDAO;
import com.itlaoqi.babytun.dao.GoodsParamDAO;
import com.itlaoqi.babytun.entity.Goods;
import com.itlaoqi.babytun.entity.GoodsCover;
import com.itlaoqi.babytun.entity.GoodsDetail;
import com.itlaoqi.babytun.entity.GoodsParam;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
/*@@请加Q群：369531466,与几百名工程师共同学习,遇到难题可随时@老齐,多一点真诚，少一点套路@@*/public class GoodsService {
    @Resource
    private GoodsDAO goodsDAO;
    @Resource
    private GoodsCoverDAO goodsCoverDAO;
    @Resource
    private GoodsDetailDAO goodsDetailDAO;
    @Resource
    private GoodsParamDAO goodsParamDAO;
    //view -> controller -> service -> dao

    //@Cacheable是声明式缓存的核心注解
    //第一次访问的时候将方法的返回结果放入缓存
    //第二次访问时不再执行方法内部的代码，而是从缓存中直接提取数据。
    @Cacheable(value="goods" , key = "#goodsId") //key:  goods::1  goods::2
    public Goods getGoods(Long goodsId) {
        return goodsDAO.findById(goodsId);
    }

    @Cacheable(value="covers" , key = "#goodsId")
    public List<GoodsCover> findCovers(Long goodsId){
        return goodsCoverDAO.findByGoodsId(goodsId);
    }
    @Cacheable(value="details" , key = "#goodsId")
    public List<GoodsDetail> findDetails(Long goodsId){
        return  goodsDetailDAO.findByGoodsId(goodsId);
    }
    @Cacheable(value="params" , key = "#goodsId")
    public List<GoodsParam> findParams(Long goodsId){
        List list =  goodsParamDAO.findByGoodsId(goodsId);
        return list;
    }

}
