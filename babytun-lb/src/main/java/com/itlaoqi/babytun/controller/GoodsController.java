package com.itlaoqi.babytun.controller;

import com.itlaoqi.babytun.entity.Goods;
import com.itlaoqi.babytun.service.GoodsService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import org.slf4j.*;

@Controller
/*@@请加Q群：369531466,与几百名工程师共同学习,遇到难题可随时@老齐,多一点真诚，少一点套路@@*/public class GoodsController {
    Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Value("${server.port}")
    private String port ;

    @Resource
    private GoodsService goodsService;
    @GetMapping("/goods-{gid}.html") //http://localhost/goods?gid=xxx
    public ModelAndView showGoods(@PathVariable("gid") Long gid){
        logger.info("port:" + port);
        ModelAndView mav = new ModelAndView("/goods");
        Goods goods = goodsService.getGoods(gid);
        mav.addObject("goods", goods);
        mav.addObject("covers", goodsService.findCovers(gid));
        mav.addObject("details", goodsService.findDetails(gid));
        mav.addObject("params", goodsService.findParams(gid));
        return mav;
    }
    @GetMapping("/login")
    @ResponseBody
    public String login(String u , WebRequest request){
        request.setAttribute("user" , u , WebRequest.SCOPE_SESSION);
        return "port:" + port +",login success";
    }
    @GetMapping("/check")
    @ResponseBody
    public String checkUser(WebRequest request){
        String user = (String)request.getAttribute("user", WebRequest.SCOPE_SESSION);
        if(user != null){
            return "port:" + port + ",user=" + user;
        }else{
            return "port:" + port + ", redirect to login!";
        }
    }
}
