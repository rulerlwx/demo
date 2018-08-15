package com.demo.jdkproxy.service.impl;

import com.demo.jdkproxy.service.PersonService;

/**
 * Created by lwx on 2018/8/15.
 */
public class PersonServiceImpl implements PersonService {

    @Override
    public String getPersonName() {
        System.out.println("我是getPersonName()方法");
        return "xxxx";
    }

}
