package com.tecsun.test;

import com.tecsun.proxy.JDKProxyFactory;
import com.tecsun.service.PersonService;
import com.tecsun.service.impl.PersonServiceImpl;

public class ProxyTest {

	public static void main(String[] args) {
		JDKProxyFactory proxyFactory = new JDKProxyFactory();
		PersonService service = (PersonService) proxyFactory.createProxyInstance(new PersonServiceImpl());
		System.out.println(service.getPersonName());
	}
}
