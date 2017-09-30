package com.demo.jedis;

import org.junit.Test;

/**
 * Created by lwx on 2017/9/27.
 */
public class ArrayTest {

    /**
     * 数组定义的三种方式
     */
    @Test
    public void testArray(){
        String[] arr =  new String[3];
        arr[0] = "a";
        arr[1] = "b";
        arr[2] = "c";
        System.out.println(arr);

        String[] arr2 = new String[]{"a","b","c"};

        String[] arr3 = {"a","b","c"};
    }
}
