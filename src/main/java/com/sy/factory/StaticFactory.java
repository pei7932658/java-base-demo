package com.sy.factory;

public class StaticFactory {
	public static Person createMan(){
		return new Man();
	}
	public static Person createWomen(){
		return new Women();
	}
}
