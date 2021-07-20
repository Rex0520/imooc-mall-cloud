package com.imooc.cloud.mall.practice.advertisement.model.request;


import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @description: 更新广告表单
 * @author: Rex
 * @create: 2021-07-19 19:03
 */
public class UpdateAdvertisementReq implements Serializable {
  public static final long serialVersionUID = -1L;

  /**
   * 广告编号
   */
  @NotNull(message = "id不能为null")
  private Integer id;

  /**
   * 广告名称
   */
  private String name;

  /**
   * 广告详情
   */
  private String detail;

  /**
   * 广告图片
   */
  private String image;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

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
        "id=" + id +
        ", name='" + name + '\'' +
        ", detail='" + detail + '\'' +
        ", image='" + image + '\'' +
        '}';
  }
}
