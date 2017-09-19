package com.niuka.common.util;

import java.util.Calendar;

public class WeekUtils {
	
	/** 
     * get Calendar of given year 
     * @param year 
     * @return 
     */  
    private static Calendar getCalendarFormYear(int year){  
        Calendar cal = Calendar.getInstance();  
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);        
        cal.set(Calendar.YEAR, year);  
        return cal;  
    }  
    
	 /** 
     * get start date of given week no of a year 
     * @param year 
     * @param weekNo 
     * @return 
     */  
    public static String getStartDayOfWeekNo(int year,int weekNo){  
        Calendar cal = getCalendarFormYear(year);  
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);  
        return cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" +  
               cal.get(Calendar.DAY_OF_MONTH);      
          
    }  
      
    /** 
     * get the end day of given week no of a year. 
     * @param year 
     * @param weekNo 
     * @return 
     */  
    public static String getEndDayOfWeekNo(int year,int weekNo){  
        Calendar cal = getCalendarFormYear(year);  
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);  
        cal.add(Calendar.DAY_OF_WEEK, 6);  
        return cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" +  
               cal.get(Calendar.DAY_OF_MONTH);      
    }  
}
