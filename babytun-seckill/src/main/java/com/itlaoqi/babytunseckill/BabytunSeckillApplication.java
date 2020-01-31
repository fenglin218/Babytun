package com.itlaoqi.babytunseckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.itlaoqi.babytunseckill")
@EnableScheduling //启用任务调度功能
/*@@请加Q群：369531466,与几百名工程师共同学习,遇到难题可随时@老齐,多一点真诚，少一点套路@@*/public class BabytunSeckillApplication {
	//修改默认的redisTemplate持久化方式,这块的知识可以学习“小白轻松学Redis”课程
	@Bean
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		//设置value的序列化方式为JSOn
		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
		//设置key的序列化方式为String
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		return redisTemplate;
	}
	public static void main(String[] args) {
		SpringApplication.run(BabytunSeckillApplication.class, args);
	}
}
