package com.imooc.cloud.mall.practice.cartorder.feign;

import com.imooc.cloud.mall.practice.categoryproduct.model.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description: 商品FeignClient
 * @author: Rex
 * @create: 2021-07-13 19:07
 */
@FeignClient(value = "cloud-mall-category-product")
public interface ProductFeignClient {

  @GetMapping("product/detailForFeign")
  Product detailForFeign(@RequestParam Integer id);

  @PostMapping("product/updateStock")
  void updateStock(@RequestParam Integer productId, @RequestParam Integer stock);
}
