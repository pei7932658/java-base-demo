package com.sy.spring4_2.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.util.CollectionUtils;

public class CollectionUtilsTest {
	public static void main(String[] args) {
		String[] ss = new String[]{"a","b","c"};
		List list = CollectionUtils.arrayToList(ss);
		for(Object o : list){
			//System.out.println(o.toString());
		}
		
		List<String> list1 = new ArrayList<String>();
			list1.add("d");
			list1.add("e");
			list1.add("f");
			list1.add("f");
			list1.add("f");
			list1.add("f");
			list1.add("f");
			list1.add("f");
			list1.add("f");
		CollectionUtils.mergeArrayIntoCollection(ss, list1);
		for(Object o : list1){
			//System.out.println(o.toString());
		}
		
		List list2 = Arrays.asList("a","b","c");
		list2.add("d");
	}
}
