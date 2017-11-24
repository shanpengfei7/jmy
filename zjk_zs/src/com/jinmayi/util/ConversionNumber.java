package com.jinmayi.util;

public class ConversionNumber {

	private static String X36 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	  
	//10进制转换成36进制
	public static String ConvertTo36(int val)
	    {
	      String result = "";
	      while (val >= 36)
	      {
	        result = X36.charAt(val % 36) + result;
	        val /= 36;
	      }
	      if (val >= 0) result = X36.charAt(val) + result;
	      return result;
	    }
	//36进制转换成10进制
	public static int ConvertTo10(String str)
	    {
	      int result = 0;
	      int len = str.length();
	      for (int i = len; i > 0; i--)
	      {
	    	  result += X36.indexOf(str.charAt(i-1))*Math.pow(36, len-i);
	      }
	      return result;
	    }

}
