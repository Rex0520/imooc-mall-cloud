package com.imooc.cloud.mall.practice.cartorder.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: 地址映射配置
 * @author: Rex
 * @create: 2021-07-14 22:12
 */
@Configuration
public class ImoocMallWebMvcConfig implements WebMvcConfigurer {

  @Value("${file.upload.dir}")
  String FILE_UPLOAD_DIR;

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    WebMvcConfigurer.super.addResourceHandlers(registry);
    registry.addResourceHandler("/images/**").addResourceLocations("file:"+FILE_UPLOAD_DIR);
  }
}
