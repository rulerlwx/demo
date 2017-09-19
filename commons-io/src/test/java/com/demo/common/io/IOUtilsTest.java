package com.demo.common.io;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created by lwx on 2017/9/19.
 */
public class IOUtilsTest {

    /**
     * IOUtils.toString
     */
    @Test
    public void testToString(){

        try(InputStream in = new URL( "http://commons.apache.org" ).openStream();) {

            System.out.println(IOUtils.toString(in, StandardCharsets.UTF_8));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //IOUtils.closeQuietly(in);
        }
    }


}
