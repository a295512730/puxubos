package org.framework.web.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace="http://web.ws.framework.org/",serviceName="UserService",portName="UserServicePort")
public interface IUserService {

	@WebResult(name="helloResult",targetNamespace="http://web.ws.framework.org/")
	@WebMethod(operationName="sayHello")
	public String hello(@WebParam(name="arg0")String userName);
	
	
	@WebResult(name="loginResult",targetNamespace="http://web.ws.framework.org/")
	@WebMethod(operationName="sayLogin")
	public String login(@WebParam(name="arg0")String loginName,@WebParam(name="arg1")String pwd);
}
