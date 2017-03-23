package org.framework.web.test.ws;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestUserService {
	private static final QName SERVICE_NAME = new QName("http://web.ws.framework.org/", "UserService");
	private static final QName PORT_NAME = new QName("http://web.ws.framework.org/", "UserServicePort");
	private IUserService us = null;
	
	
	@Before
	public void before(){
		//下面的3步指的是获取网络上的接口代理
		Service service = Service.create(SERVICE_NAME);
		String endPointAddress = "http://localhost:8080/web/services/UserService";
		service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endPointAddress);
		//把本地客户端的接口与网络上的WSDL连接起来
		us = service.getPort(IUserService.class);
	}
	
	
	@Ignore
	public void testSayHello(){
	
		//然后就可以直接调用了
		System.out.println(us.sayHello("小明，"));
	}
	
	@Ignore
	public void testSayLogin(){
		System.out.println(us.sayLogin("不知道,", "123456"));
		
	}
	
	
	
	
}
