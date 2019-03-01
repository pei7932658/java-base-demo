package com.sy.desginer.prototype;

import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		clone2();
	}
	public static void deepclone(){
		Prototype prototype = new Prototype();
		System.out.println(prototype.a);
		try {
			//Prototype clonePro = prototype.clone();
			Prototype clonePro = prototype.deepClone();
				System.out.println(clonePro.a);
				System.out.println(prototype == clonePro);
				System.out.println(prototype.equals(clonePro));
				System.out.println(prototype.getModel() == clonePro.getModel());
				System.out.println(prototype.getModel().equals(clonePro.getModel()));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void clone2(){
		Prototype prototype = new Prototype();
		System.out.println(prototype.a);
		try {
			Prototype clonePro = prototype.clone();
			System.out.println(clonePro.a);
			System.out.println(prototype == clonePro);
			System.out.println(prototype.equals(clonePro));
			System.out.println(prototype.getModel() == clonePro.getModel());
			System.out.println(prototype.getModel().equals(clonePro.getModel()));
		}catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
