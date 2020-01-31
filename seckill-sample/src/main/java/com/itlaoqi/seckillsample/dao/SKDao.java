package com.itlaoqi.seckillsample.dao;

/*@@请加Q群：369531466,与几百名工程师共同学习,遇到难题可随时@老齐,多一点真诚，少一点套路@@*/public class SKDao {
    public static Integer count = 10;
    public Integer getCount(){
        return SKDao.count;
    }

    public void updateCount(Integer count){
        SKDao.count = count;
    }
}
