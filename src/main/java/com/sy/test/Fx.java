package com.sy.test;

public class Fx<T> {
	private T ob;
	
	
	public Fx(T ob){
		this.ob = ob;
	}
	public T getOb() {
		return ob;
	}
	public void setOb(T ob) {
		this.ob = ob;
	}
	
	public void showType(){
		System.out.println("T的实际类型是: " + ob.getClass().getName());  
	}
	
	public static void main(String[] args) {
		Fx<Integer> fx = new Fx<Integer>(10);
		fx.showType();
		System.out.println("value= " + fx.getOb());
		
		System.out.println("-------------------------------------");
		
		Fx<String> strOb = new Fx<String>("CSDN_SEU_Calvin");  
        strOb.showType();  
        System.out.println("value= " + strOb.getOb());  
        
        System.out.println("-------------------------------------");
        
        Fx<Number> ex_num = new Fx<Number>(100);  
        Fx<Integer> ex_int = new Fx<Integer>(200);  
        Fx<String> ex_string = new Fx<String>("string");  
        
        getData(ex_num);
        getData(ex_int);//编译错误
        getData(ex_string);
        
        System.out.println("-------------------------------------");
        
        Fx<Number> ex_num1 = new Fx<Number>(100);  
        Fx<Integer> ex_int1 = new Fx<Integer>(200);  
        Fx<String> ex_string1 = new Fx<String>("string");  
        getUpperNumberData(ex_num1);  
        getUpperNumberData(ex_int1); 
       //getUpperNumberData(ex_string1);
        
	}
	
	public static void getData(Fx<?> temp){
		 temp.showType();
		 System.out.println("value= " + temp.getOb());  
	}
	
	public static void getUpperNumberData(Fx<? extends Number> temp){  
	      System.out.println("class type :" + temp.getClass());  
	      System.out.println("value= " + temp.getOb());  
	} 

}
