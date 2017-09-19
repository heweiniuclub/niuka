package com.niuka.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.CharUtils;

public class WxNicknameCovertUtil {
	public static String filterEmoji(String content){
		try {
			
			 if(content != null)
	         {
	             Pattern emoji = Pattern.compile ("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",Pattern.UNICODE_CASE | Pattern . CASE_INSENSITIVE ) ;
	             Matcher emojiMatcher = emoji.matcher(content);
	             if (emojiMatcher.find())
	             {
	            	 content = emojiMatcher.replaceAll("*"); 
	             }	        
	        }
			
			
			System.out.println("微信昵称转化："+content);
			if(content.contains("🎵")){
				content=content.replaceAll("🎵", "");
	        }
			
			byte[] t1 = content.getBytes("UTF-8");  
	        for (int i = 0; i < t1.length;) {  
	            byte tt = t1[i];  
	            if (CharUtils.isAscii((char) tt)) {  
	                byte[] ba = new byte[1];  
	                ba[0] = tt;  
	                i++;  
	                String result = new String(ba);  
	            }  
	            if ((tt & 0xE0) == 0xC0) {  
	                byte[] ba = new byte[2];  
	                ba[0] = tt;  
	                ba[1] = t1[i+1];  
	                i++;  
	                i++;  
	                String result = new String(ba);  
	            }  
	            if ((tt & 0xF0) == 0xE0) {  
	                byte[] ba = new byte[3];  
	                ba[0] = tt;  
	                ba[1] = t1[i+1];  
	                ba[2] = t1[i+2];  
	                i++;  
	                i++;
	                i++;  
	                String result = new String(ba,"UTF-8");  
	                
	                String regex = "[\u4E00-\u9FA5]+";
	                if(!result.matches(regex)){
	                	content = content.replace(result, "");
	                }
	            }  
	            if ((tt & 0xF8) == 0xF0) {
	                byte[] ba = new byte[4];  
	                ba[0] = tt;  
	                ba[1] = t1[i+1];  
	                ba[2] = t1[i+2];  
	                ba[3] = t1[i+3];  
	                i++;  
	                i++;  
	                i++;  
	                i++;  
	                String result = new String(ba);  
	            }  
	        } 
	        
	        
	       
	        
	        
		}catch(Exception e){
			System.out.println("微信昵称转化出错："+content);
			e.printStackTrace();
			content="";
		}
		return content.trim();
	}
}
