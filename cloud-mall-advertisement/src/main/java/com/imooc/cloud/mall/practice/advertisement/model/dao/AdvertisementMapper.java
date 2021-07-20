package com.imooc.cloud.mall.practice.advertisement.model.dao;

import com.imooc.cloud.mall.practice.advertisement.model.pojo.Advertisement;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: 广告mapper
 * @author: Rex
 * @create: 2021-07-17 14:03
 */
@Repository
public interface AdvertisementMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(Advertisement advertisement);

  int insertSelective(Advertisement advertisement);

  Advertisement selectByPrimaryKey(Integer id);

  Advertisement selectByName(String name);

  int updateByPrimaryKeySelective(Advertisement advertisement);

  int updateByPrimaryKey(Advertisement advertisement);

  List<Advertisement> selectList(@Param("keyword") String keyword);
}
