package com.imooc.cloud.mall.practice.zuul.feign;

import com.imooc.cloud.mall.practice.user.model.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: UserFeignClient
 * @Author: Rex
 * @Create: 2021-07-09 20:02
 */
@FeignClient(value = "cloud-mall-user")
public interface UserFeignClient {
  /**
   * 校验是否是管理员
   * @param user
   * @return
   */
  @PostMapping("/checkAdminRole")
  Boolean checkAdminRole(@RequestBody User user);
}
