package com.imooc.cloud.mall.practice.user.service;

import com.imooc.cloud.mall.practice.common.exception.ImoocMallException;
import com.imooc.cloud.mall.practice.user.model.pojo.User;

/**
 * UserService
 * @author Rex
 * @create 2021-02-07 14:42
 */
public interface UserService {


    void register(String userName, String password) throws ImoocMallException;

    User login(String userName, String password) throws ImoocMallException;

    void updateInformation(User user) throws ImoocMallException;

    boolean checkAdminRole(User user);
}
