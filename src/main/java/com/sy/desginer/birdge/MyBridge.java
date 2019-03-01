package com.sy.desginer.birdge;

public class MyBridge extends Bridge {

	@Override
	public void method() {
		getSourceable().method();
	}
	
}
