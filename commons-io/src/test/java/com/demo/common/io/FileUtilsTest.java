package com.demo.common.io;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * Created by lwx on 2017/9/19.
 */
public class FileUtilsTest {

    /**
     * FileUtils.readLines，有什么用？？？
     */
    @Test
    public void test1(){
        try {
            File file = new File("e:/project.properties");  //一定是相对于电脑文件系统的路径
            List lines = FileUtils.readLines(file, "UTF-8");
            for(Object o:lines){
                System.out.println(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
