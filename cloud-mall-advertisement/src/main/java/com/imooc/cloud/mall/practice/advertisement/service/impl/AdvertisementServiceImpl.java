package com.imooc.cloud.mall.practice.advertisement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.cloud.mall.practice.advertisement.model.dao.AdvertisementMapper;
import com.imooc.cloud.mall.practice.advertisement.model.pojo.Advertisement;
import com.imooc.cloud.mall.practice.advertisement.model.request.AddAdvertisementReq;
import com.imooc.cloud.mall.practice.advertisement.model.request.AdvertisementListReq;
import com.imooc.cloud.mall.practice.advertisement.model.request.UpdateAdvertisementReq;
import com.imooc.cloud.mall.practice.advertisement.service.AdvertisementService;
import com.imooc.cloud.mall.practice.common.exception.ImoocMallException;
import com.imooc.cloud.mall.practice.common.exception.ImoocMallExceptionEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 广告服务类
 * @author: Rex
 * @create: 2021-07-17 14:24
 */
@Service
public class AdvertisementServiceImpl implements AdvertisementService {

  @Autowired
  private AdvertisementMapper advertisementMapper;

  /**
   * 获取广告列表
   * @param advertisementListReq 广告列表请求列表
   * @return 广告列表
   */
  @Override
  public PageInfo<Advertisement> list(AdvertisementListReq advertisementListReq){
    PageHelper.startPage(advertisementListReq.getPageNum(), advertisementListReq.getPageSize());
    List<Advertisement> advertisements;
    if (advertisementListReq.getKeyword() != null) {
      String keyword = advertisementListReq.getKeyword();
      keyword = new StringBuilder("%").append(keyword).append("%").toString();
      advertisements = advertisementMapper.selectList(keyword);
    }else{
      advertisements = advertisementMapper.selectList(null);
    }

    return new PageInfo<>(advertisements);
  }


  /**
   * 根据id查询广告详情
   * @param id 广告编号
   * @return 广告详情
   */
  @Override
  public Advertisement detail(Integer id){
    return advertisementMapper.selectByPrimaryKey(id);
  }

  /**
   * 添加广告
   * @param addAdvertisementReq 添加广告表单
   */
  @Override
  public void add(AddAdvertisementReq addAdvertisementReq){
    Advertisement old = advertisementMapper.selectByName(addAdvertisementReq.getName());
    if (old != null){
      throw new ImoocMallException(ImoocMallExceptionEnum.NAME_EXISTED);
    }
    Advertisement advertisement = new Advertisement();
    BeanUtils.copyProperties(addAdvertisementReq, advertisement);
    int cnt = advertisementMapper.insertSelective(advertisement);
    if (cnt == 0){
      throw new ImoocMallException(ImoocMallExceptionEnum.CREATE_FAILED);
    }

  }

  /**
   * 更新广告
   * @param updateAdvertisementReq 更新广告表单
   */
  @Override
  public void update(UpdateAdvertisementReq updateAdvertisementReq){
    Advertisement advertisement = new Advertisement();
    BeanUtils.copyProperties(updateAdvertisementReq, advertisement);
    if (advertisement.getName() != null){
      Advertisement old = advertisementMapper.selectByName(advertisement.getName());
      if (old != null && !old.getId().equals(advertisement.getId())){
        throw new ImoocMallException(ImoocMallExceptionEnum.NAME_EXISTED);
      }
    }
    int cnt = advertisementMapper.updateByPrimaryKeySelective(advertisement);
    if (cnt == 0){
      throw new ImoocMallException(ImoocMallExceptionEnum.UPDATE_FAILED);
    }
  }

  /**
   * 删除广告
   * @param id 广告id
   */
  @Override
  public void delete(Integer id){
    Advertisement advertisement = advertisementMapper.selectByPrimaryKey(id);
    //查不到记录，无法删除，删除失败
    if (advertisement == null) {
      throw new ImoocMallException(ImoocMallExceptionEnum.DELETE_FAILED);
    }
    int count = advertisementMapper.deleteByPrimaryKey(id);
    if (count == 0){
      throw new ImoocMallException(ImoocMallExceptionEnum.DELETE_FAILED);
    }
  }
}
