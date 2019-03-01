package com.sy.jaxb2.test;

import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.util.ResourceUtils;

import com.sy.jaxb2.model.Tasks;

/**
 * 利用jaxb2协议，将xml转换成Bean
* @author peiliang
* @date : 2017年5月6日 下午10:19:31
*/
public class Xml2ModelTest {
	
	//定义bean属性的包路径
	private static final String[] XML_MAPPING_OBJECT_PACKAGE = new String[]{"com.sy.jaxb2.model"};
	public static void main(String[] args) {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setPackagesToScan(XML_MAPPING_OBJECT_PACKAGE);
		
		try {
			File file = ResourceUtils.getFile("D:\\nsb-scheduler\\tasks\\Poverty_task251.xml");
			System.out.println(file.exists());
			Object obj = jaxb2Marshaller.unmarshal(new StreamSource(file));
			Tasks tasks = (Tasks)obj;
			System.out.println(tasks.getGroups().get(0).getName());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		InputStream is = Xml2ModelTest.class.getClassLoader().getResourceAsStream("Poverty_task251.xml");
//		System.out.println(is.toString());
		
	}
}
