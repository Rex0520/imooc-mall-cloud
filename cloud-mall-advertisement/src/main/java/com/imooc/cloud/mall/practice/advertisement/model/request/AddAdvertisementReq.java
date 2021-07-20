package com.imooc.cloud.mall.practice.advertisement.model.request;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @description: 更新广告表单
 * @author: Rex
 * @create: 2021-07-19 19:03
 */
public class AddAdvertisementReq implements Serializable {
  public static final long serialVersionUID = -1L;

  /**
   * 广告名称
   */
  @NotBlank(message = "广告名称不能为空")
  private String name;

  /**
   * 广告详情
   */
  @NotBlank(message = "广告详情不能为空")
  private String detail;

  /**
   * 广告图片
   */
  @NotBlank(message = "广告图片不能为空")
  private String image;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  @Override
  public String toString() {
    return "UpdateAdvertisementReq{" +
        "name='" + name + '\'' +
        ", detail='" + detail + '\'' +
        ", image='" + image + '\'' +
        '}';
  }
}
