package com.sy.pei.thread;

import java.util.ArrayList;
import java.util.List;

public class SynchroTest  {  
	  
    public static void main(String args[]) {  
        Plate myPlate = new Plate();  
        new Thread(new Get(myPlate)).start();  
        new Thread(new Add(myPlate)).start();  
    }  
} 

class Plate  {
	 private List<Object> apples = new ArrayList<Object>(); 
	 
	 public synchronized void putApple(Object apple){
		 if(apples.size()>0){
			 try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
		 apples.add(apple);
		 notify();
		 System.out.println("放入了一个苹果");  
	 }
	 
	 public synchronized void getApple(){
		 if(apples.size() ==0){
			 try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
		 Object apple = apples.get(0); 
		 	apples.clear();  
	        notify();  
	        System.out.println("拿到一个苹果");  
	 }
}

class Add implements Runnable {  
	  
    private Plate applePlate;  
      
    private Object apple = new Object();  
      
    public Add(Plate applePlate) {  
        this.applePlate = applePlate;  
    }  
      
    public void run() {  
        for(int i=0; i<5;i++) {  
            applePlate.putApple(apple);  
        }  
    }  
      
}  
  
class Get implements Runnable {  
  
    private Plate applePlate;  
      
    public Get(Plate applePlate) {  
        this.applePlate = applePlate;  
    }  
      
  
    public void run() {  
        for(int i=0; i<5;i++) {  
            applePlate.getApple();  
        }  
    }  
      
}
