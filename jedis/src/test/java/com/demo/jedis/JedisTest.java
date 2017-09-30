package com.demo.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by lwx on 2017/9/27.
 */
public class JedisTest {

    @Test
    public void testJedis(){
        Jedis jedis = new Jedis("localhost");
    }
}
