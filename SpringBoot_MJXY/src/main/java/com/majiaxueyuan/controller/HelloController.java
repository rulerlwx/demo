package com.majiaxueyuan.controller;

import com.majiaxueyuan.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lwx on 2019/2/23.
 */
@RestController
public class HelloController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @RequestMapping("/excep")
    public String excep(){
        int i = 1/0;    //这里将抛出异常
        return "hell,exception";
    }

    @RequestMapping("/getUserById")
    public Object getUserById(Long id){
        return userMapper.getUserById(id);
    }
}
