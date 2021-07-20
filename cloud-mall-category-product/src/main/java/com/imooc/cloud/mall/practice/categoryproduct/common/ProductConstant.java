package com.imooc.cloud.mall.practice.categoryproduct.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @description: 商品常量类
 * @author: Rex
 * @create: 2021-07-12 20:48
 */
@Component
public class ProductConstant {

  public static String FILE_UPLOAD_DIR;

  @Value(value = "${file.upload.dir}")
  public void setFileUploadDir(String fileUploadDir){
    FILE_UPLOAD_DIR = fileUploadDir;
  }
}
