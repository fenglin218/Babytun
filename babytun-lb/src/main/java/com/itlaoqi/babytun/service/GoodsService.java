package com.itlaoqi.babytun.service;

import com.itlaoqi.babytun.dao.GoodsCoverDAO;
import com.itlaoqi.babytun.dao.GoodsDAO;
import com.itlaoqi.babytun.dao.GoodsDetailDAO;
import com.itlaoqi.babytun.dao.GoodsParamDAO;
import com.itlaoqi.babytun.entity.Goods;
import com.itlaoqi.babytun.entity.GoodsCover;
import com.itlaoqi.babytun.entity.GoodsDetail;
import com.itlaoqi.babytun.entity.GoodsParam;
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
    public Goods getGoods(Long goodsId) {
        return goodsDAO.findById(goodsId);
    }

    public List<GoodsCover> findCovers(Long goodsId){
        return goodsCoverDAO.findByGoodsId(goodsId);
    }

    public List<GoodsDetail> findDetails(Long goodsId){
        return  goodsDetailDAO.findByGoodsId(goodsId);
    }

    public List<GoodsParam> findParams(Long goodsId){
        List list =  goodsParamDAO.findByGoodsId(goodsId);
        return list;
    }

}
