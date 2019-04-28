package com.majiaxueyuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lwx on 2019/2/24.
 */
@Controller
public class PageController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
