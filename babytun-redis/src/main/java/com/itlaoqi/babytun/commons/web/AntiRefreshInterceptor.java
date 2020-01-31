package com.itlaoqi.babytun.commons.web;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@Component
/*@@请加Q群：369531466,与几百名工程师共同学习,遇到难题可随时@老齐,多一点真诚，少一点套路@@*/public class AntiRefreshInterceptor implements HandlerInterceptor{
    @Resource
    //RedisTemplate用于简化Redis操作，在IOC容器中自动被初始化
    private RedisTemplate<String, Object> redisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("PreHandler");
        String clientIP = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");
        System.out.println(userAgent);
        String key = "anti:refresh:" + DigestUtils.md5Hex(clientIP + "_" + userAgent);

        response.setContentType("text/html;charset=utf-8");

        if(redisTemplate.hasKey("anti:refresh:blacklist")){
            if (redisTemplate.opsForSet().isMember("anti:refresh:blacklist", clientIP)) {
                response.getWriter().println("检测到您的IP访问异常，已被加入黑名单");
                return false;
            }
        }


        Integer num = (Integer)redisTemplate.opsForValue().get(key);
        if(num == null){ //第一次访问
            redisTemplate.opsForValue().set(key, 1, 60, TimeUnit.SECONDS);
        }else{

            if(num > 30 && num  < 100){
                response.getWriter().println("请求过于频繁，请稍后再试!");
                redisTemplate.opsForValue().increment(key, 1);
                return false;
            }else if(num >=100){
                response.getWriter().println("检测到您的IP访问异常，已被加入黑名单");
                redisTemplate.opsForSet().add("anti:refresh:blacklist" , clientIP);
                return false;
            }else{
                redisTemplate.opsForValue().increment(key, 1);
            }
        }
        return true;
    }
}
