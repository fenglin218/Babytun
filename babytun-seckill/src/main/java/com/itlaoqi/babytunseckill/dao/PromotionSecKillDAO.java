package com.itlaoqi.babytunseckill.dao;

import com.itlaoqi.babytunseckill.entity.PromotionSecKill;

import java.util.List;

public interface PromotionSecKillDAO {
    List<PromotionSecKill> findUnstartSecKill();
    void update(PromotionSecKill ps);
    PromotionSecKill findById(Long psId);
    List<PromotionSecKill> findExpireSecKill();
}
