package com.itlaoqi.babytun.controller;

import com.itlaoqi.babytun.entity.Goods;
import com.itlaoqi.babytun.service.GoodsService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import org.slf4j.*;

@Controller
/*@@请加Q群：369531466,与几百名工程师共同学习,遇到难题可随时@老齐,多一点真诚，少一点套路@@*/public class GoodsController {
    Logger logger = LoggerFactory.getLogger(GoodsController.class);
    @Resource
    private GoodsService goodsService;
    @GetMapping("/goods") //http://localhost/goods?gid=xxx
    public ModelAndView showGoods(Long gid){
        logger.info("gid:" + gid);
        ModelAndView mav = new ModelAndView("/goods");
        Goods goods = goodsService.getGoods(gid);
        mav.addObject("goods", goods);
        mav.addObject("covers", goodsService.findCovers(gid));
        mav.addObject("details", goodsService.findDetails(gid));
        mav.addObject("params", goodsService.findParams(gid));
        return mav;
    }
}
