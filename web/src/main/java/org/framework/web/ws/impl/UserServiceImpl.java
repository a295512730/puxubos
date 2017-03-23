package org.framework.web.ws.impl;

import javax.jws.WebService;

import org.framework.web.ws.IUserService;

@WebService(endpointInterface="org.framework.web.ws.IUserService")
public class UserServiceImpl implements IUserService {
	
	
	public String hello(String userName) {
		// TODO Auto-generated method stub
		return userName + "你好！";
	}

	
	public String login(String loginName, String pwd) {
		// TODO Auto-generated method stub
		
		
		return loginName + "登陆成功！";
	}

}
