package com.imooc.cloud.mall.practice.advertisement.model.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 广告实体类
 * @author: Rex
 * @create: 2021-07-17 13:56
 */
public class Advertisement implements Serializable {
  private static final long serialVersionUID = -1L;

  /**
   * 广告编号
   */
  private Integer id;

  /**
   * 广告名称
   */
  private String name;

  /**
   * 广告图片
   */
  private String image;

  /**
   * 广告详情
   */
  private String detail;

  /**
   * 创建时间
   */
  private Date createTime;

  /**
   * 更新时间
   */
  private Date updateTime;

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

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }
}
