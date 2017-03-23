package org.framework.web.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Messager {

	private boolean status;
	
	private String msg;

	public Messager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Messager(boolean status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}

	@XmlElement
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@XmlElement
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
