package com.imooc.cloud.mall.practice.categoryproduct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @description: CategoryProductApplication
 * @author: Rex
 * @create: 2021-07-12 19:23
 */
@SpringBootApplication
@EnableFeignClients
@EnableRedisHttpSession
@MapperScan(basePackages = {"com.imooc.cloud.mall.practice.categoryproduct.model.dao"})
public class CategoryProductApplication {
  public static void main(String[] args) {
    SpringApplication.run(CategoryProductApplication.class, args);
  }
}
