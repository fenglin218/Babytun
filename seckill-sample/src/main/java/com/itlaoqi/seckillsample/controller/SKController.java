package com.itlaoqi.seckillsample.controller;

import com.itlaoqi.seckillsample.service.SKService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
/*@@请加Q群：369531466,与几百名工程师共同学习,遇到难题可随时@老齐,多一点真诚，少一点套路@@*/public class SKController {
    @Resource
    private SKService skService = null;

    @GetMapping("/seckill")
    @ResponseBody
    public String doSeckill(){
        skService.processSeckill();
        return "ok";
    }
}
