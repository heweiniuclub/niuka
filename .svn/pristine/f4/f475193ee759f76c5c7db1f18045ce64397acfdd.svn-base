package com.niuka.common.util;

public class LocationUtils {

	private static double EARTH_RADIUS = 6378.137;
	
	private static double rad(double d) {    
        return d * Math.PI / 180.0;    
    }    
    
    /**   
     * 通过经纬度获取距离(单位：KM)   
     * @param lat1   纬度
     * @param lng1   经度
     * @param lat2   
     * @param lng2   
     * @return   
     */    
    public static double getDistance(double lat1, double lng1, double lat2, double lng2) {    
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)    
                + Math.cos(radLat1) * Math.cos(radLat2)    
                * Math.pow(Math.sin(b / 2), 2)));    
        s = s * EARTH_RADIUS;    
        s = Math.round(s * 10000d) / 10000d;  
        return s;    
    }
    
//	public static void main(String[] args) {
//		Double lat1 = 22.643422496892317d;
//		Double lng1 = 114.07061576843262d;
//		Double lat2 = 22.996846d;
//		Double lng2 = 113.723427;
//		Double distance = LocationUtils.getDistance(lat1, lng1, lat2, lng2) ;
//		System.out.println(distance);
//	}

}
