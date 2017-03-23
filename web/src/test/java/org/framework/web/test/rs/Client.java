package org.framework.web.test.rs;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.framework.web.beans.Customer;
import org.framework.web.util.JAXBTools;

public class Client {

	public static void main(String[] args) {
		
		Client client = new Client();
		client.addCustomerInfo();
//		client.getCustomerById(1L);
//		client.updateCustomerInfo();
//		client.deleteCustomerInfo();
	}
	
	private void deleteCustomerInfo() {
		// TODO Auto-generated method stub
		Customer customer = getCustomerById(1L);
		if(customer == null){
			return;
		}
		
		DeleteMethod delete = new DeleteMethod("http://localhost:8080/web/services/CustomerService/customerservice/customers/"+1L);
		setMethodHeaders(delete);
		try {
			handleHttpMethod(delete);
			
			System.out.println(delete.getResponseBodyAsString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			delete.releaseConnection();
		}
	}

	private void updateCustomerInfo() {
		// TODO Auto-generated method stub
		Customer customer = getCustomerById(1L);
		
		PutMethod put = new PutMethod("http://localhost:8080/web/services/CustomerService/customerservice/customers/"+1L);
		setMethodHeaders(put);
		
		customer.setName("真强");
		try {
			
			String xmls = JAXBTools.java2Xml(Customer.class, customer);
			RequestEntity entity = new InputStreamRequestEntity(new ByteArrayInputStream(xmls.getBytes("UTF-8")));
			put.setRequestEntity(entity);
			handleHttpMethod(put);
			
			
			System.out.println(put.getResponseBodyAsString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			put.releaseConnection();
		}
	}

	public void addCustomerInfo() {
		// TODO Auto-generated method stub
		PostMethod post = new PostMethod("http://localhost:8080/web/services/CustomerService/customerservice/customers");
		setMethodHeaders(post);
		
		Customer cus = new Customer(2L,"浩哥","123456");
		try {
			String xmls = JAXBTools.java2Xml(Customer.class, cus);
			RequestEntity entity = new InputStreamRequestEntity(new ByteArrayInputStream(xmls.getBytes("UTF-8")));
			post.setRequestEntity(entity);
			handleHttpMethod(post);
			
			System.out.println(post.getResponseBodyAsString());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			post.releaseConnection();
		}
		
		
	}

	/**
	 * GET方式获取数据
	 */
	public Customer getCustomerById(Long id) {
		// TODO Auto-generated method stub
		GetMethod get = new GetMethod("http://localhost:8080/web/services/CustomerService/customerservice/customers/"+id);
		setMethodHeaders(get);
		handleHttpMethod(get);
		Customer customer = null;
		try {
			String str = get.getResponseBodyAsString();//返回的是XML格式的字符串
			
			System.out.println(str);
			
			try {
				//将返回的字符串，转换为JAVA类
				customer = (Customer) JAXBTools.xml2Java(Customer.class, str);
				
				System.out.println(customer);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			get.releaseConnection();
		}
		return customer;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 用于执行Http请求
	 * @param get
	 */
	private static void handleHttpMethod(HttpMethod method) {
		// TODO Auto-generated method stub
		HttpClient client = new HttpClient();
		int ret = 0;
		
		try {
			ret = client.executeMethod(method);
			Response.Status status = Response.Status.fromStatusCode(ret);
			//当返回等于200时
			if(status == Response.Status.OK){
				System.out.println("Authorication true");
			}else if(status == Response.Status.FORBIDDEN){
				System.out.println("Authorication failure");
			}
			
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 设置HTTP的请求头
	 */
	public static void setMethodHeaders(HttpMethod method){
		if(method instanceof PostMethod || method instanceof PutMethod) {
			method.setRequestHeader("Content-Type", "application/xml;charset=UTF-8");
		}
		method.setRequestHeader("Accept", "application/xml;charset=UTF-8");
		//e10adc3949ba59abbe56e057f20f883e 用户登录时，服务器发给客户端用于保持状态的令牌信息
		method.setRequestHeader("Authorication", "e10adc3949ba59abbe56e057f20f883e");
	}
	
}
