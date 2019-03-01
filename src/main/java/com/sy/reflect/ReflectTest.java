package com.sy.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectTest {
	
	public static Car initConst() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Class<?> clazz = Class.forName("com.sy.reflect.Car");
		Field[] fileds = clazz.getDeclaredFields();
		for(Field filed :fileds){
			 // 权限修饰符
            int mo = filed.getModifiers();
            String priv = Modifier.toString(mo);
           
            // 属性类型
            Class<?> type = filed.getType();
            System.out.println(priv + " " + type.getName() + " " + filed.getName() + ";");
		}
		
		Car car =(Car)clazz.newInstance();
		Method brandMethod = clazz.getMethod("setBrand", String.class);
			brandMethod.invoke(car, "红旗九");
		Method colorMethod = clazz.getMethod("setColor", String.class);
		colorMethod.invoke(car, "red");
		Method speedMethod = clazz.getMethod("setMaxSpeed", int.class);
			speedMethod.invoke(car, 120);
		
		return car;
	}
	
	public static void main(String[] args) {
		try {
			Car car = initConst();
			car.introduce();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException
				| SecurityException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
