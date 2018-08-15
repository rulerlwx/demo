package com.demo.jdkproxy.test;

import com.demo.jdkproxy.proxy.JDKProxyFactory;
import com.demo.jdkproxy.service.PersonService;
import com.demo.jdkproxy.service.impl.PersonServiceImpl;

/**
 * Created by lwx on 2018/8/15.
 */
public class ProxyTest {
    public static void main(String[] args) {
        JDKProxyFactory proxyFactory = new JDKProxyFactory();
        PersonService service = (PersonService) proxyFactory.createProxyInstance(new PersonServiceImpl());
        System.out.println(service.getPersonName());
    }
}
