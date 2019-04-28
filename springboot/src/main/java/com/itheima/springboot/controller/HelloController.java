package com.itheima.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lwx on 2019/2/23.
 */
@RestController
@RequestMapping("/springmvc")
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(){
        return "hello spring boot";
    }
}
