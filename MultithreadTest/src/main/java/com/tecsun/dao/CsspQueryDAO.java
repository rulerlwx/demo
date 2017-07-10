package com.tecsun.dao;


import java.util.List;
import java.util.Map;

import com.tecsun.server.PersonInfo;
import com.tecsun.util.MyBatisDao;

@MyBatisDao
public interface CsspQueryDAO {

	int getPersonInfoCount();

	List<PersonInfo> listPersonInfo(Map<String,Integer> map);

	int insertPersonInfo(List<PersonInfo> list);
	
}
