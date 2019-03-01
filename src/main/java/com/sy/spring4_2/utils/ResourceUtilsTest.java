package com.sy.spring4_2.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.util.ResourceUtils;

public class ResourceUtilsTest {
	public static void main(String[] args) {
		try {
			File file = ResourceUtils.getFile("d:/1.txt");
			FileReader reader = new FileReader(file);
			int ch = 0;  
	        while((ch = reader.read()) != -1){  
	            System.out.print((char)ch);  
	        } 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
