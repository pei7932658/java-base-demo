package com.sy.desginer.birdge;

public class TestBridge {
	public static void main(String[] args) {
		MyBridge myBridge = new MyBridge();
			myBridge.setSourceable(new SourceSub1());
			myBridge.method();
			myBridge.setSourceable(new SourceSub2());
			myBridge.method();
	}
}
