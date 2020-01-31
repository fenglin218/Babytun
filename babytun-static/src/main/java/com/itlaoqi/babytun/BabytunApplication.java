package com.itlaoqi.babytun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.itlaoqi.babytun") //mybatis在SpringBoot启动的时候自动扫描mybatis实现的接口
@EnableScheduling//自动任务调度
/*@@请加Q群：369531466,与几百名工程师共同学习,遇到难题可随时@老齐,多一点真诚，少一点套路@@*/public class BabytunApplication {
	public static void main(String[] args) {
		SpringApplication.run(BabytunApplication.class, args);
	}
}
