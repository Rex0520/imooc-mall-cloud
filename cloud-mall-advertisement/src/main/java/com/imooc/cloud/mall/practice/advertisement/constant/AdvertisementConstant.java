package com.imooc.cloud.mall.practice.advertisement.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @description: 上传图片的路径
 * @author: Rex
 * @create: 2021-07-17 21:02
 */
@Component
public class AdvertisementConstant {
  public static String FILE_UPLOAD_DIR;

  @Value(value = "${file.upload.dir}")
  public void setFileUploadDir(String fileUploadDir){
    FILE_UPLOAD_DIR = fileUploadDir;
  }
}
