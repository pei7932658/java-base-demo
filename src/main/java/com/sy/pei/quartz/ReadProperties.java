package com.sy.pei.quartz;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	public static void main(String[] args) {
		try {
			Properties properties = new Properties();
			InputStream is = ReadProperties.class.getClassLoader().getResourceAsStream("test.properties");
			properties.load(is);
			String filepath = properties.getProperty("scheduler.file.path");
			String logpath =  properties.getProperty("scheduler.log.path");
			System.out.println(filepath);
			System.out.println(logpath);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
