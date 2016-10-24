package com.shankes.baidu.location.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shankes.baidu.city.domain.CityInfo;
import com.shankes.baidu.util.HttpRequestBaiduUtil;

public class LocationUtil {
	private static String HTTP_URL = "http://api.map.baidu.com/cloudrgc/v1";
	// 请求接口参数
	// *40.047,116.313 格式：纬度,经度
	String location = "LAT,LNG";
	// * 位置表id,与ak配合鉴权
	String geotable_id = "geotable_id=GEOTABLE_ID";
	String extensions = "extensions=EXTENSIONS";// 扩展信息控制,pois是否返回扩展信息：默认不返回，extensions=pois时返回pois和custom_pois
	String coord_type = "coord_type=COORD_TYPE";// 坐标系,默认为
												// :bd09ll,bd09ll（百度经纬度坐标）、gcj02ll（国测局经纬度坐标）、wgs84ll（wgs84经纬度坐标）
	// * 鉴权密钥,可在API控制台中创建
	String ak = "ak=AK";
	String sn = "sn=SN";// 权限签名,
	String timestamp = "timestamp=TIMESTAMP";// 鉴权时间戳,配合sn鉴权
	// private static String HTTP_ARG = "cityname=%E5%8C%97%E4%BA%AC";
	private static String HTTP_ARG = "cityname=CITY";

	public static CityInfo getCityInfo(String cityValue) {
		CityInfo cityInfo = null;
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
