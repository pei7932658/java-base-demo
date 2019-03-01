package com.sy.jaxb2.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Task {
	
	@XmlAttribute
	private String name;
	
	@XmlAttribute
	private String type;
	
	@XmlAttribute
	private int priority;
	
	@XmlAttribute
	private String triggerName;
	
	@XmlAttribute(name="cron")
	private String cronExpression;
	
	@XmlAttribute
	private String phone;
	
	@XmlElement
	private HttpTask http;
	
	@XmlElement
	private ApiTask api;

	@XmlElement
	private SystemTask system;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getTriggerName() {
		return triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public HttpTask getHttp() {
		return http;
	}

	public void setHttp(HttpTask http) {
		this.http = http;
	}

	public ApiTask getApi() {
		return api;
	}

	public void setApi(ApiTask api) {
		this.api = api;
	}

	public SystemTask getSystem() {
		return system;
	}

	public void setSystem(SystemTask system) {
		this.system = system;
	}
	
}
