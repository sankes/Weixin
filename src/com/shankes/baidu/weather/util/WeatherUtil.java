package com.shankes.baidu.weather.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shankes.amap.geocoding.regeo.domain.LocationInfo;
import com.shankes.amap.geocoding.regeo.util.LocationUtil;
import com.shankes.baidu.iplocation.domain.IpLocationInfo;
import com.shankes.baidu.iplocation.util.IpLocationUtil;
import com.shankes.baidu.util.HttpRequestBaiduUtil;
import com.shankes.baidu.weather.domain.WeatherInfo;

public class WeatherUtil {

	private static String HTTP_URL = "http://apis.baidu.com/apistore/weatherservice/cityname";
	// private static String HTTP_ARG = "cityname=%E5%8C%97%E4%BA%AC";
	private static String HTTP_ARG = "cityname=CITY";

	/**
	 * 根据城市名获取天气
	 * 
	 * @param cityValue
	 * @return
	 */
	public static WeatherInfo getWeatherInfo(String cityValue) {
		WeatherInfo weatherInfo = null;
		if (cityValue != null && !"".equals(cityValue)) {
			if (cityValue.endsWith("市"))
				cityValue = cityValue.replace("市", "");
			try {
				cityValue = URLEncoder.encode(cityValue, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			String httpArg = HTTP_ARG.replace("CITY", cityValue);
			// 发送请求后就得到了json字符串
			String jsonStr = HttpRequestBaiduUtil.request(HTTP_URL, httpArg);
			// JSON的核心代码
			Gson gson = new GsonBuilder().create();
			try {
				// 这里会自动将Unicode编码转为中文
				weatherInfo = gson.fromJson(jsonStr, WeatherInfo.class);
			} catch (Exception e) {

			}
		}
		return weatherInfo;
	}

	/**
	 * 根据ip获取天气
	 * 
	 * @param ipValue
	 *            空值,默认为当前主机ip,"222.76.241.234";
	 * @return
	 */
	public static WeatherInfo getWeatherInfoFromIp(String ipValue) {
		// 先根据本机ip获取所在城市名
		IpLocationInfo ipLocationInfo = IpLocationUtil.getIpLocationInfo(null);
		String cityValue = ipLocationInfo.getContent().getAddress_detail()
				.getCity();
		WeatherInfo weatherInfo = getWeatherInfo(cityValue);
		return weatherInfo;
	}

	/**
	 * 根据经纬度获取天气,这里调用高德地图提供的逆地理编码(根据经纬度获取城市)的方法
	 * 
	 * @param latitude
	 *            纬度,x,"24.482438"
	 * @param longitude
	 *            经度,y,"118.184064"
	 * @return
	 */
	public static WeatherInfo getWeatherInfoFromGeo(String latitude,
			String longitude) {
		WeatherInfo weatherInfo = null;
		LocationInfo locationInfo = LocationUtil.getLocationInfo(latitude,
				longitude);
		String cityValue = locationInfo.getRegeocodes().getAddressComponent()
				.getCity();
		weatherInfo = getWeatherInfo(cityValue);
		return weatherInfo;
	}

	public static void main(String[] args) {
//		WeatherInfo weatherInfo = getWeatherInfo("厦门");
		WeatherInfo weatherInfo = getWeatherInfoFromIp(null);
		System.out.println(weatherInfo.toString());
	}

}
