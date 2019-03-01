package com.sy.pei.thread;

public class Thread1 extends Thread {
	
	int i=0;
	@Override
	public void run() {
		for(;i<100;i++){  
	        System.out.println(this.getName()+"  "+i);  
	       }  
	}
	
	 public static void main(String[] args)  
	    {  
	        for(int i = 0;i< 100;i++)  
	        {  
	            System.out.println(Thread.currentThread().getName()+"  : "+i);  
	            if(i==20)  
	            {  
	                new Thread1().run();  
	                new Thread1().run();  
	            }  
	        }  
	    } 
}
