package com.itheima.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by lwx on 2019/2/23.
 */
@SpringBootApplication  //表明当前类是SpringBoot的引导类
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

//        SpringApplication application = new SpringApplication(Application.class);
//        application.setBannerMode(Banner.Mode.OFF);
//        application.run(args);
    }

    /**
     * springboot会自动扫描com.itheima.springboot包及其子包，其它的包不扫描。
     */
}
