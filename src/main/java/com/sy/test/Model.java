package com.sy.test;

import java.io.Serializable;


//懒汉，双重锁
public class Model implements Serializable{
	private static volatile Model model;

	private Model(){

	}

	public static Model getModel(){
		synchronized (Model.class)
		{
			if(model == null){
				model = new Model();
			}
			return model;
		}
	}
}

//懒汉模式(线程安全)
class M2{
	private static M2 m = new M2();

	private M2(){}

	public static synchronized M2 getM2(){
		return m;
	}
}
