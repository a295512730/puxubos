package org.framework.web.rs.impl;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.framework.web.beans.Customer;
import org.framework.web.beans.Messager;
import org.framework.web.rs.CustomerService;
import org.framework.web.util.MD5Util;

public class CustomerServiceImpl implements CustomerService {

	Map<Long,Customer> customers = new HashMap<Long,Customer>();
	
	public CustomerServiceImpl(){
		init();
	}
	
	public void init(){
		customers.put(1L, new Customer(1L,"多多","123456"));
	}
	
	@Override
	public Response getCustomer(HttpHeaders headers,Long id) {
		// TODO Auto-generated method stub
		System.out.println("CustomerServiceImpl---------getCustomer,id="+id);
		Customer customer = customers.get(id);
		
		
		//根据ID查询用户，获得用户名与密码，并且同样加密，
		//将加密后的结果与客户端的Authorication进行比对，判断是否是同一人
		String Authorication = headers.getHeaderString("Authorication");
		String md5 = MD5Util.encode("123456");
		if(!Authorication.equals(md5)){
			return Response.status(Status.FORBIDDEN).build();
		}
		
		return Response.ok(customer).build();
	}
	

	@Override
	public Response addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("CustomerServiceImpl---------addCustomer,customer="+customer);
		customers.put(customer.getId(), customer);
		Messager message = new Messager(true, "添加成功");
		return Response.ok(message).build();
	}

	@Override
	public Response updateCustomer(Long id, Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("CustomerServiceImpl---------updateCustomer,customer="+customer);
		customers.put(customer.getId(), customer);
		Messager message = new Messager(true, "修改成功");
		return Response.ok(message).build();
	}

	@Override
	public Response deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		System.out.println("CustomerServiceImpl---------deleteCustomer,id="+id);
		customers.remove(id);
		Messager message = new Messager(true, "删除成功");
		return Response.ok(message).build();
	}


}
