package com.imooc.cloud.mall.practice.categoryproduct.service;


import com.github.pagehelper.PageInfo;
import com.imooc.cloud.mall.practice.categoryproduct.model.pojo.Category;
import com.imooc.cloud.mall.practice.categoryproduct.model.request.AddCategoryReq;
import com.imooc.cloud.mall.practice.categoryproduct.model.vo.CategoryVO;

import java.util.List;

/**
 * 分类目录Service
 * @author Rex
 * @create 2021-02-09 12:30
 */
public interface CategoryService {

    void add(AddCategoryReq addCategoryReq);

    void update(Category updateCateogry);

    void delete(Integer id);

    PageInfo<Category> listForAdmin(Integer pageNum, Integer pageSize);

    List<CategoryVO> listCategoryForCustomer(Integer parentId);
}
