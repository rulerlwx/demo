package com.tecsun.service.impl;

import com.tecsun.service.PersonService;

public class PersonServiceImpl implements PersonService {

	@Override
	public String getPersonName() {
		System.out.println("����getPersonName()����");
		return "xxxx";
	}

}
