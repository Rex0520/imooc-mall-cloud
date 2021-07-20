package com.imooc.cloud.mall.practice.cartorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @description: 购物车订单模块启动类
 * @author: Rex
 * @create: 2021-07-13 18:55
 */
@SpringBootApplication
@MapperScan(basePackages = "com.imooc.cloud.mall.practice.cartorder.model.dao")
@EnableRedisHttpSession
@EnableFeignClients
public class CartOrderApplication {
  public static void main(String[] args) {
    SpringApplication.run(CartOrderApplication.class, args);
  }
}
