package com.itlaoqi.babytun.scheduler;

import com.itlaoqi.babytun.entity.Goods;
import com.itlaoqi.babytun.service.GoodsService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component //组件类，IOC容器扫描到后会自动实例化加载
/*@@请加Q群：369531466,与几百名工程师共同学习,遇到难题可随时@老齐,多一点真诚，少一点套路@@*/public class StaticTask {
    @Resource
    private GoodsService goodsService;
    @Resource
    private Configuration freemarkerConfig;
    //public void  xxx(){}
    //* * * * * ? 每秒钟执行一次
    //秒 分 小时 日 月 星期
    //* 代表所有时间
    @Scheduled(cron = "0 0/5 * * * ?")
    public void doStatic() throws IOException, TemplateException {
        //获取模板对象
        Template template = freemarkerConfig.getTemplate("goods.ftl");
        List<Goods> allGoods = goodsService.findLast5M();
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
            System.out.println(new Date()+ ":" +targetFile +"已生成！");
            out.close();
        }
    }
}
