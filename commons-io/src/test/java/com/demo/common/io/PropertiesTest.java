package com.demo.common.io;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by lwx on 2017/9/19.
 */
public class PropertiesTest {

    /**
     * FileUtilsTest.class.getClassLoader().getResourceAsStream 默认加载的路径是编译
     * 后class目录（不包括子目录）的文件
     */
    @Test
    public void testLoadProperties(){
        try {
            InputStream is = FileUtilsTest.class.getClassLoader().getResourceAsStream("project.properties");

            Properties properties = new Properties();
            properties.load(is);

            String pass = properties.getProperty("user.model.pass");
            System.out.println("user.model.pass:"+pass);

            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
