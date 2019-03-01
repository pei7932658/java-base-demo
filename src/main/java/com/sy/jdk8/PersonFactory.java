package com.sy.jdk8;

public interface PersonFactory <P extends Person>{
	P create(String name,Integer age);
}
