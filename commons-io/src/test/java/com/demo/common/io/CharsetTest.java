package com.demo.common.io;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * Created by lwx on 2017/9/19.
 */
public class CharsetTest {

    /**
     * decode、encode
     */
    @Test
    public void testCharset(){
        Charset cn = Charset.forName("GBK");
        ByteBuffer byteBuffer = cn.encode("孙");
        for(int i = 0; i<byteBuffer.capacity(); i++){
            System.out.println(byteBuffer.get(i));
        }
        CharBuffer charBuffer = cn.decode(byteBuffer);
        System.out.println(charBuffer);

    }
}
