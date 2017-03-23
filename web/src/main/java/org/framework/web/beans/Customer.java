package org.framework.web.beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Customer")
public class Customer {

	
	private Long id;
	
	private String name;
	
	private String password;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(Long id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	@XmlAttribute
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password="
				+ password + "]";
	}
	
	
}
