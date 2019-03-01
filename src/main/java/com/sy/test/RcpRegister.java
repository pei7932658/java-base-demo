package com.sy.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RcpRegister {
	
	  private static char[] base64EncodeChars = { 'A', 'B', 'C', 'D', 
			    'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 
			    'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 
			    'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 
			    'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', 
			    '4', '5', '6', '7', '8', '9', '+', '/' };
	public static void main(String[] args) {
		 MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("SHA");
			 md5.update(("420826997".toUpperCase() + "whsy").getBytes());
			 String licence = new String(encode(md5.digest()));
			 System.out.println(licence);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	public static String encode(byte[] data)
	  {
	    StringBuffer sb = new StringBuffer();
	    int len = data.length;
	    int i = 0;

	    while (i < len) {
	      int b1 = data[(i++)] & 0xFF;
	      if (i == len) {
	        sb.append(base64EncodeChars[(b1 >>> 2)]);
	        sb.append(base64EncodeChars[((b1 & 0x3) << 4)]);
	        sb.append("==");
	        break;
	      }
	      int b2 = data[(i++)] & 0xFF;
	      if (i == len) {
	        sb.append(base64EncodeChars[(b1 >>> 2)]);
	        sb.append(base64EncodeChars[
	          ((b1 & 0x3) << 4 | 
	          (b2 & 0xF0) >>> 4)]);
	        sb.append(base64EncodeChars[((b2 & 0xF) << 2)]);
	        sb.append("=");
	        break;
	      }
	      int b3 = data[(i++)] & 0xFF;
	      sb.append(base64EncodeChars[(b1 >>> 2)]);
	      sb.append(base64EncodeChars[
	        ((b1 & 0x3) << 4 | 
	        (b2 & 0xF0) >>> 4)]);
	      sb.append(base64EncodeChars[
	        ((b2 & 0xF) << 2 | 
	        (b3 & 0xC0) >>> 6)]);
	      sb.append(base64EncodeChars[(b3 & 0x3F)]);
	    }
	    return sb.toString();
	  }
}
