package com.sy.jaxb2.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Tasks {
	
	@XmlElement(name="group")
	private List<TaskGroup> groups = new ArrayList<TaskGroup>();

	public List<TaskGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<TaskGroup> groups) {
		this.groups = groups;
	}
	
}
