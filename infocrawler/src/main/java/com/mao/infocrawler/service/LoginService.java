package com.mao.infocrawler.service;

import com.mao.infocrawler.model.dao.common.IOperations;
import com.mao.infocrawler.model.entity.User;


public interface LoginService extends IOperations<User>  {
	
	boolean checkLogin(String id,String password);
	
	String registUser(String userid,String username,String password,String usertype);

	User findOneUser(String id);

}
