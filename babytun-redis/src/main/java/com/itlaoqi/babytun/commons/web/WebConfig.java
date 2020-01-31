package com.itlaoqi.babytun.commons.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
/*@@请加Q群：369531466,与几百名工程师共同学习,遇到难题可随时@老齐,多一点真诚，少一点套路@@*/public class WebConfig implements WebMvcConfigurer{
    @Resource
    AntiRefreshInterceptor antiRefreshInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(antiRefreshInterceptor).addPathPatterns(new String[]{"/goods" , "/gid/" , "/abc/**"});

    }
}