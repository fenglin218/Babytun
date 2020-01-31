package com.itlaoqi.babytun.controller;

import com.itlaoqi.babytun.entity.Evaluate;
import com.itlaoqi.babytun.entity.Goods;
import com.itlaoqi.babytun.service.GoodsService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import org.slf4j.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
/*@@请加Q群：369531466,与几百名工程师共同学习,遇到难题可随时@老齐,多一点真诚，少一点套路@@*/public class GoodsController {
    Logger logger = LoggerFactory.getLogger(GoodsController.class);
    @Resource
    private GoodsService goodsService;
    //Freemaker的核心配置类，用于动态生成模板对象
    //在SpringBoot IOC容器初始化的时候，自动Configuration就被实例化
    @Resource
    private Configuration freemarkerConfig;
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

    @GetMapping("/static/{gid}")
    @ResponseBody
    public String doStatic(@PathVariable("gid") Long gid) throws IOException, TemplateException {
        //获取模板对象
        Template template = freemarkerConfig.getTemplate("goods.ftl");
        Map param = new HashMap();
        param.put("goods", goodsService.getGoods(gid));
        param.put("covers", goodsService.findCovers(gid));
        param.put("details", goodsService.findDetails(gid));
        param.put("params", goodsService.findParams(gid));
        File targetFile = new File("d:/babytun/goods/" + gid + ".html");
        FileWriter out = new FileWriter(targetFile);
        template.process(param , out);
        out.close();
        return targetFile.getPath();
    }

    @GetMapping("/static_all")
    @ResponseBody
    public String doStatic() throws IOException, TemplateException {
        //获取模板对象
        Template template = freemarkerConfig.getTemplate("goods.ftl");
        List<Goods> allGoods = goodsService.findAllGoods();
        for (Goods g : allGoods) {
            Long gid = g.getGoodsId();
            Map param = new HashMap();
            param.put("goods", goodsService.getGoods(gid));
            param.put("covers", goodsService.findCovers(gid));
            param.put("details", goodsService.findDetails(gid));
            param.put("params", goodsService.findParams(gid));
            File targetFile = new File("d:/babytun/goods/" + gid + ".html");
            FileWriter out = new FileWriter(targetFile);
            template.process(param , out);
            out.close();
        }

        return "ok";
    }
    @GetMapping("/evaluate/{gid}")
    @ResponseBody
    public List<Evaluate> findEvaluates(@PathVariable("gid") Long goodsId){
        return goodsService.findEvaluates(goodsId);

    }
}
