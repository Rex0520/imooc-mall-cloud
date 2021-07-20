package com.imooc.cloud.mall.practice.advertisement.service;

import com.github.pagehelper.PageInfo;
import com.imooc.cloud.mall.practice.advertisement.model.pojo.Advertisement;
import com.imooc.cloud.mall.practice.advertisement.model.request.AddAdvertisementReq;
import com.imooc.cloud.mall.practice.advertisement.model.request.AdvertisementListReq;
import com.imooc.cloud.mall.practice.advertisement.model.request.UpdateAdvertisementReq;

/**
 * @description: 广告Service
 * @author: Rex
 * @create: 2021-07-17 14:24
 */
public interface AdvertisementService {

  /**
   * 获取广告列表
   * @param advertisementListReq 广告列表请求列表
   * @return 广告列表
   */
  PageInfo<Advertisement> list(AdvertisementListReq advertisementListReq);

  /**
   * 根据id查询广告详情
   * @param id 广告编号
   * @return 广告详情
   */
  Advertisement detail(Integer id);

  /**
   * 添加广告
   * @param addAdvertisementReq 添加广告表单
   */
  void add(AddAdvertisementReq addAdvertisementReq);

  /**
   * 更新广告
   * @param updateAdvertisementReq 更新广告表单
   */
  void update(UpdateAdvertisementReq updateAdvertisementReq);

  /**
   * 删除广告
   * @param id 广告id
   */
  void delete(Integer id);
}
