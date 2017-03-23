package org.framework.web.rs;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.framework.web.beans.Customer;

@Path("/customerservice/")
public interface CustomerService {
	
	
	/**
	 * 根据ID查询客户
	 * @param id
	 * @return
	 */
	@GET
	@Path("/customers/{id}")
	Response getCustomer(@Context HttpHeaders headers,@PathParam("id")Long id);
	
	/**
	 * 添加数据
	 * @param customer
	 * @return
	 */
	@POST
	@Path("/customers")
	Response addCustomer(Customer customer);
	
	/**
	 * 修改数据
	 * @param id
	 * @param customer
	 * @return
	 */
	@PUT
	@Path("customers/{id}")
	Response updateCustomer(@PathParam("id")Long id,Customer customer);
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("customers/{id}")
	Response deleteCustomer(@PathParam("id")Long id);
	
	
	
}
