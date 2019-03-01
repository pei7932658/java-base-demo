package com.sy.pei;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.jdbc.StringUtils;

/**
 * Hello world!
 *
 */
public class App 
{
	//定义一个全局的记录器，通过LoggerFactory获取
    private final static Logger logger = LoggerFactory.getLogger(App.class); 
    /**
    * @param args
    */

   public static void main(String[] args) {
	   
       logger.info("logback 成功了");
       logger.error("logback 成功了");
   }
}
