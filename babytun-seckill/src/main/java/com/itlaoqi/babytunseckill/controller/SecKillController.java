package com.itlaoqi.babytunseckill.controller;

import com.itlaoqi.babytunseckill.entity.Order;
import com.itlaoqi.babytunseckill.entity.PromotionSecKill;
import com.itlaoqi.babytunseckill.service.PromotionSecKillService;
import com.itlaoqi.babytunseckill.service.exception.SecKillException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
/*@@请加Q群：369531466,与几百名工程师共同学习,遇到难题可随时@老齐,多一点真诚，少一点套路@@*/public class SecKillController {
    @Resource
    PromotionSecKillService promotionSecKillService;
    @RequestMapping("/seckill")
    @ResponseBody
    public Map processSecKill(Long psid , String userid){
        Map result = new HashMap();
        try {
            promotionSecKillService.processSecKill(psid , userid , 1);
            String orderNo = promotionSecKillService.sendOrderToQueue(userid);
            Map data = new HashMap();
            data.put("orderNo", orderNo);
            result.put("code", "0");
            result.put("message", "success");
            result.put("data", data);
        } catch (SecKillException e) {
            result.put("code", "500");
            result.put("message", e.getMessage());
        }
        return result;
    }
    @GetMapping("/checkorder")
    public ModelAndView checkOrder(String orderNo){
        Order order =  promotionSecKillService.checkOrder(orderNo);
        ModelAndView mav = new ModelAndView();
        if(order != null){
            mav.addObject("order", order);
            mav.setViewName("/order");
        }else{
            mav.addObject("orderNo", orderNo);
            mav.setViewName("/waiting");
        }
        return mav;
    }
}
