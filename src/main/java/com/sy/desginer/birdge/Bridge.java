package com.sy.desginer.birdge;

public abstract class Bridge {
	private Sourceable sourceable;
	
	/**
	 * 桥接的方法
	 */
	public void method(){
		sourceable.method();
	}
	
	
	public Sourceable getSourceable() {
		return sourceable;
	}

	public void setSourceable(Sourceable sourceable) {
		this.sourceable = sourceable;
	}
	
	
}
