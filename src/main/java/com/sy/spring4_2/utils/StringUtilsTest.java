package com.sy.spring4_2.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.springframework.util.StringUtils;

public class StringUtilsTest {
	public static void main(String[] args) {
		String s="abc_123";
		System.out.println("字符串长度是否为0："+StringUtils.hasLength(s));
		
		System.out.println("--------------------------我是分割线--------------------------");
		
		String s1="";
		System.out.println("是否非空值，包括空格："+StringUtils.hasText(s1));
		System.out.println("is null or is '' ："+StringUtils.isEmpty(s1));
		
		System.out.println("--------------------------我是分割线--------------------------");
		
		String s2="  aa bb  cc ";
		System.out.println("是否包括空格："+StringUtils.containsWhitespace(s2));
		System.out.println("删除开头空格："+StringUtils.trimLeadingWhitespace(s2));
		System.out.println("删除结尾空格："+StringUtils.trimTrailingWhitespace(s2));
		System.out.println("删除开头和结尾的空格："+StringUtils.trimWhitespace(s2));
		System.out.println("删除所有空格："+StringUtils.trimAllWhitespace(s2));
		
		System.out.println("--------------------------我是分割线--------------------------");
		
		String s3="abc_123";
		System.out.println("删除开头指定字符："+StringUtils.trimLeadingCharacter(s3, 'a'));
		System.out.println("删除结尾指定字符："+StringUtils.trimTrailingCharacter(s3, '3'));
		
		String[] arr = new String[]{" abc "," 1 23","ef d "};
		for(String a : StringUtils.trimArrayElements(arr) ){
			System.out.println("删除字符串数组开头结尾空格："+a);
		}
		
		System.out.println("--------------------------我是分割线--------------------------");
		
		String s4="abc_123_ef";
		System.out.println("字符串以指定串开头(忽略大小写)："+StringUtils.startsWithIgnoreCase(s4, "AB"));
		System.out.println("字符串以指定串结尾(忽略大小写)："+StringUtils.endsWithIgnoreCase(s4, "EF"));
		
		System.out.println("--------------------------我是分割线--------------------------");
		String s5="abc_123_ef";
		System.out.println("指定s5从下标4开始,如果能截取出123相等的内容就返回true："+StringUtils.substringMatch(s5, 4, "123"));
		
		System.out.println("--------------------------我是分割线--------------------------");
		System.out.println("统计str中包含多少个sub字符串:"+StringUtils.countOccurrencesOf("abc_123_ef_123", "123"));
		
		System.out.println("--------------------------我是分割线--------------------------");
		System.out.println("把字符串inString 中 oldParam 全部替换成 newParam:"+StringUtils.replace("abc_123_ef_123", "123", "321"));
		System.out.println("把字符串inString 中 pattern字符串全部删除掉:"+StringUtils.delete("abc_123_ef_123", "123"));
		System.out.println("把字符串inString 中 包含pattern字符串中任意字符的全部删除掉:"+StringUtils.deleteAny("abc_123_ef_123", "13"));
		
		System.out.println("--------------------------我是分割线--------------------------");
		System.out.println("只要字符串不等于null 就加上引号:"+StringUtils.quote("name"));
		System.out.println("只要传入的是String并且不等于null 就加上引号:"+StringUtils.quoteIfString(new Integer(1)));
		
		System.out.println("--------------------------我是分割线--------------------------");
		System.out.println("截取最后出现.号的，后半截:"+StringUtils.unqualify("this.peter.liang"));
		System.out.println("截取最后出现传入字符的后半截:"+StringUtils.unqualify("this-peter-liang", '-'));
		
		System.out.println("--------------------------我是分割线--------------------------");
		System.out.println("让第一个字母大写:"+StringUtils.capitalize("this.peter.liang"));
		System.out.println("让第一个字母小写:"+StringUtils.uncapitalize("This.peter.liang"));
		
		System.out.println("--------------------------我是分割线--------------------------");
		System.out.println("获取路径中文件名称，包括后缀:"+StringUtils.getFilename("d:/peter/1.txt"));
		System.out.println("获取路径中文件后缀:"+StringUtils.getFilenameExtension("d:/peter/1.txt"));
		System.out.println("去掉路径中文件后缀:"+StringUtils.stripFilenameExtension("d:/peter/1.txt"));
		System.out.println("不知道干什么用:"+StringUtils.applyRelativePath("d:/peter/1.txt","/liang"));
		System.out.println("不知道干什么用:"+StringUtils.cleanPath("d:/peter/1.txt"));
		System.out.println("不知道干什么用:"+StringUtils.pathEquals("d:/peter/1.txt","d:\\peter\\1.txt"));
		
		System.out.println("--------------------------我是分割线--------------------------");
		String[] arr2 =new String[]{"11","22","33"};
		/*String[] arr3 =new String[4];
		System.arraycopy(arr2, 0, arr3, 0, arr2.length);
		for(String s11 : arr3){
			System.out.println(s11);
		}*/
		String[] arr4 =new String[]{"55","11","44"};
		System.out.println("把字符串加到数组中:"+StringUtils.addStringToArray(arr2, "44"));
		//把两数组组合一起
		String arr5[] = StringUtils.concatenateStringArrays(arr2, arr4);
		/*for(String s11 : arr5){
			System.out.println(s11);
		}*/
		//把两数组去重组合一起
		String arr6[] = StringUtils.mergeStringArrays(arr2, arr4);
		/*for(String s11 : arr6){
			System.out.println(s11);
		}*/
		//把数组排序
		String arr7[] = StringUtils.sortStringArray(arr4);
		/*for(String str : arr7){
			System.out.println(str);
		}*/
		
		//把集合转换成String数组
		List<String> list = Arrays.asList("Buenos Aires", "Córdoba", "La Plata");
		String arr8[] = StringUtils.toStringArray(list);
		/*for(String str : arr8){
			System.out.println(str);
		}*/
		
		//把数组里面的字符串去掉前后空格
		String[] arr9 =new String[]{" 5 5 ","11 "," 44"};
		String arr10[] = StringUtils.trimArrayElements(arr9);
		/*for(String str : arr10){
			System.out.println(str);
		}*/
		
		//数组去重
		String[] arr11 =new String[]{"aa","bb","aa"};
		String arr12[] = StringUtils.removeDuplicateStrings(arr11);
		/*for(String str : arr12){
			System.out.println(str);
		}*/
		
		//第一出现指定分隔符拆分字符串成数组
		String s6 = "a-b-c-1-2";
		/*String arr13[] = StringUtils.split(s6, "-");
		for(String str : arr13){
			System.out.println(str);
		}*/
		
		System.out.println("--------------------------我是分割线--------------------------");
		//把数组转换成Properties，并且可以分隔出来key value
		String[] arr14 = new String[]{"key1#value1","key2#value2","key3#value3"};
		Properties pro1 =  StringUtils.splitArrayElementsIntoProperties(arr14, "#");
		System.out.println(pro1.getProperty("key1"));
		
		System.out.println("--------------------------我是分割线--------------------------");
		//将字符串按指定字符分隔，并且去掉分隔之后的单个前后空格，去掉空字符
		String arr15[] = StringUtils.tokenizeToStringArray("a#b#c#a#ab#bc# # sd # 1 23", "#");
		/*for(String str : arr15){
			System.out.println(str);
		}*/
		
		//把字符串分隔成数组并且去掉指定字符
		String arr16[] = StringUtils.delimitedListToStringArray("a#b#c#a#ab#bc# # sd # 1 23", "#","b");
		for(String str : arr16){
			System.out.println(str);
		}
	}
	
}
