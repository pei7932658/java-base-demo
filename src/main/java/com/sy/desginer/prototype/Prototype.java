package com.sy.desginer.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Prototype implements Cloneable,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name ="A";
	public float a=4f;
	private static Model model = new Model();
	static{
		model.setName("pei");
	}
	
	//浅复制
	public Prototype clone() throws CloneNotSupportedException{
		Prototype po = (Prototype)super.clone();
		return po;
	}

	//深复制
	public Prototype deepClone() throws IOException, ClassNotFoundException{
		 /* 写入当前对象的二进制流 */  
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		
		/* 读出二进制流产生的新对象 */
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);

		oos.close();
		bos.close();

		return (Prototype)ois.readObject();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static Model getModel() {
		return model;
	}
	public static void setModel(Model model) {
		Prototype.model = model;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(a);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prototype other = (Prototype) obj;
		if (Float.floatToIntBits(a) != Float.floatToIntBits(other.a))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
