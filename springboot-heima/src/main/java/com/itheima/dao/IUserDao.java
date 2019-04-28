package com.itheima.dao;

import com.itheima.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lwx on 2019/2/23.
 *
 * 用户的持久层接口
 */
@Repository("userDao")
public interface IUserDao extends JpaRepository<User,Long>/**第一参数：操作哪个实体类，第二参数：实体类主键的数据类型*/{
    //List<User> findAll();
}
