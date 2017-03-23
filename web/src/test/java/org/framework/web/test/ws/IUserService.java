package org.framework.web.test.ws;

import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace="http://web.ws.framework.org/",serviceName="UserService",portName="UserServicePort")
public interface IUserService {

	
	
	@WebResult(name="helloResult",targetNamespace="http://web.ws.framework.org/")
	public String sayHello(String arg0);
	
	
	@WebResult(name="loginResult",targetNamespace="http://web.ws.framework.org/")
	public String sayLogin(String arg0,String arg1);
	
}
