package com.itheima.service;

import com.itheima.domain.User;

import java.util.List;

/**
 * Created by lwx on 2019/2/23.
 *
 * 用户的业务层接口
 */
public interface IUserService {
    List<User> findAllUser();
}
