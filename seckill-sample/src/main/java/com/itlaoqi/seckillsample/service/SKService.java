package com.itlaoqi.seckillsample.service;

import com.itlaoqi.seckillsample.dao.SKDao;
import org.springframework.stereotype.Service;

@Service
/*@@请加Q群：369531466,与几百名工程师共同学习,遇到难题可随时@老齐,多一点真诚，少一点套路@@*/public class SKService {
    private SKDao skDao = new SKDao();
    public void processSeckill(){
        Integer count = skDao.getCount();
        if(count > 0 ){
            System.out.println("恭喜您，你获得了购买的权利");
            count = count -1;
            skDao.updateCount(count);
        }else{
            System.out.println("抱歉，商品已经被抢购完了");
        }

    }

}
