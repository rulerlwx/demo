package com.demo;

import com.demo.proxy.CGBLIBProxyFactory;
import com.demo.service.impl.PersonServiceImpl;
import org.junit.Test;

/**
 * Created by lwx on 2018/8/15.
 */
public class CGLIBProxyTest {
    @Test
    public void testProxy(){
        CGBLIBProxyFactory proxyFactory = new CGBLIBProxyFactory();
        PersonServiceImpl service = (PersonServiceImpl) proxyFactory.createProxyInstance(new PersonServiceImpl());
        System.out.println(service.getPersonName());
    }
}
