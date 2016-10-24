package com.shankes.baidu.city.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shankes.baidu.city.domain.CityInfo;
import com.shankes.baidu.util.HttpRequestBaiduUtil;

public class CityUtil {
	private static String HTTP_URL = "http://apis.baidu.com/apistore/weatherservice/cityinfo";
	// private static String HTTP_ARG = "cityname=%E5%8C%97%E4%BA%AC";
	private static String HTTP_ARG = "cityname=CITY";

	public static CityInfo getCityInfo(String city) {
		CityInfo cityInfo = null;
		try {
			city = URLEncoder.encode(city, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String httpArg = HTTP_ARG.replace("CITY", city);
		// 发送请求后就得到了json字符串
		String jsonStr = HttpRequestBaiduUtil.request(HTTP_URL, httpArg);
		// JSON的核心代码
		Gson gson = new GsonBuilder().create();
		try {
			 cityInfo = gson.fromJson(jsonStr, CityInfo.class);
		} catch (Exception e) {

		}
		return cityInfo;
	}

	public static void main(String[] args) {
		CityInfo cityInfo = getCityInfo("厦");
		System.out.println(cityInfo.toString());
	}
}
