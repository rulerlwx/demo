package com.demo.common.io;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.*;
import java.util.List;

/**
 * Created by lwx on 2017/9/19.
 */
public class FileUtilsTest {

    /**
     * 将节点流包装成处理流，TODO....
     */
    @Test
    public void test(){
        try {
            File file = new File("");
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * java.io.File的length()返回的是文件中的内容占的字节数，一个英文字母占1个字节，一个汉字占两个字节。
     *
     * 如：文件中只有”abcde“5个字母，length()返回的是5.
     *
     * FileUtils.sizeOf(file)返回的是字节（目录时，所有文件字节相加）
     */
    @Test
    public void testSizeOf(){
        File file = new File("d:/temp/aao");
        System.out.println(file.length());

        long size = FileUtils.sizeOf(file);
        System.out.println(size);

    }

    /**
     * 循环删除一个目录下的所有文件（包括目录本身）
     */
    @Test
    public void testDeleteFile(){
        try {
            File dir = new File("d:/temp/aao");
            FileUtils.deleteDirectory(dir);     //循环删除一个目录下的所有文件（包括目录本身）
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
