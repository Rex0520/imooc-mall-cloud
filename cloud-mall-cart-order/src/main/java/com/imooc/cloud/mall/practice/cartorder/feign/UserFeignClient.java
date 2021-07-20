package com.imooc.cloud.mall.practice.cartorder.feign;

import com.imooc.cloud.mall.practice.user.model.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description: UserFeign客户端
 * @author: Rex
 * @create: 2021-07-13 19:19
 */
@FeignClient(value = "cloud-mall-user")
public interface  UserFeignClient {

  /**
   * 获取当前登录的user对象
   * @return
   */
  @GetMapping("/getUser")
  User getUser();
}
