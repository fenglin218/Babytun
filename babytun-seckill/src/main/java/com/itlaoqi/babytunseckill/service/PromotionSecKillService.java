package com.itlaoqi.babytunseckill.service;

import com.itlaoqi.babytunseckill.dao.OrderDAO;
import com.itlaoqi.babytunseckill.dao.PromotionSecKillDAO;
import com.itlaoqi.babytunseckill.entity.Order;
import com.itlaoqi.babytunseckill.entity.PromotionSecKill;
import com.itlaoqi.babytunseckill.service.exception.SecKillException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
/*@@请加Q群：369531466,与几百名工程师共同学习,遇到难题可随时@老齐,多一点真诚，少一点套路@@*/public class PromotionSecKillService {
    @Resource
    private PromotionSecKillDAO promotionSecKillDAO;
    @Resource
    private RedisTemplate redisTemplate;
    @Resource //RabbitMQ客户端
    private RabbitTemplate rabbitTemplate;

    @Resource
    private OrderDAO orderDAO;
    public void processSecKill(Long psId, String userid, Integer num) throws SecKillException {
        PromotionSecKill ps = promotionSecKillDAO.findById(psId);
        if (ps == null) {
            //秒杀活动不存在
            throw new SecKillException("秒杀活动不存在");
        }
        if (ps.getStatus() == 0) {
            throw new SecKillException("秒杀活动还未开始");
        } else if (ps.getStatus() == 2) {
            throw new SecKillException("秒杀活动已经结束");
        }
        Integer goodsId = (Integer) redisTemplate.opsForList().leftPop("seckill:count:" + ps.getPsId());
        if (goodsId != null) {
            //判断是否已经抢购过
            boolean isExisted = redisTemplate.opsForSet().isMember("seckill:users:" + ps.getPsId(), userid);
            if (!isExisted) {
                System.out.println("恭喜您，抢到商品啦。快去下单吧");
                redisTemplate.opsForSet().add("seckill:users:" + ps.getPsId(), userid);
            }else{
                redisTemplate.opsForList().rightPush("seckill:count:" + ps.getPsId(), ps.getGoodsId());
                throw new SecKillException("抱歉，您已经参加过此活动，请勿重复抢购！");
            }
        } else {
            throw new SecKillException("抱歉，该商品已被抢光，下次再来吧！！");
        }


    }

    public String sendOrderToQueue(String userid) {
        System.out.println("准备向队列发送信息");
        //订单基本信息
        Map data = new HashMap();
        data.put("userid", userid);
        String orderNo = UUID.randomUUID().toString();
        data.put("orderNo", orderNo);
        //附加额外的订单信息
        rabbitTemplate.convertAndSend("exchange-order" , null , data);
        return orderNo;
    }

    public Order checkOrder(String orderNo){
        Order order = orderDAO.findByOrderNo(orderNo);
        return order;
    }
}
