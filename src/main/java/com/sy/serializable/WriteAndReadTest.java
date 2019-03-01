package com.sy.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WriteAndReadTest {
	public static void main(String[] args) {
//		write();
		read();
	}
	
	public static void write(){
		try {
			Person p = new Person();
				p.setName("peter");
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("d:\\persion.test"));
			os.writeObject(p);
			os.flush();
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void read(){
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\persion.test"));
			
			Person p = (Person)ois.readObject();
			System.out.println(p.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
