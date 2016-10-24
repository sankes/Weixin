package com.shankes.amap.weather.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shankes.amap.geocoding.regeo.domain.LocationInfo;
import com.shankes.amap.geocoding.regeo.util.LocationUtil;
import com.shankes.amap.util.HttpRequestAmapUtil;
import com.shankes.amap.weather.domain.WeatherInfo;

/**
 * @author shankes
 * 
 * @api http://lbs.amap.com/api/webservice/guide/api/weatherinfo/#weatherinfo
 */
public class WeatherUtil {

	private static String HTTP_URL = "http://restapi.amap.com/v3/weather/weatherInfo";
	// *用户在高德地图官网申请Web服务API类型KEY
	private static final String KEY = "7234a23caa0795211ae041e96f3c7b5d";

	// * 请求服务权限标识
	private static String key = "key=KEY";// * 用户在高德地图官网申请web服务API类型KEY
	// * 城市名称
	private static String city = "city=CITY";// * 输入adcode
	// 气象类型
	private static String extensions = "extensions=EXTENSIONS";// 可选值：base/all,base:返回实况天气,all:返回预报天气
	// 返回格式
	private static String output = "output=OUTPUT";// 可选值：JSON,XML,默认:JSON

	private static StringBuffer HTTP_ARG = null;

	/**
	 * @param cityAdcodeValue
	 *            例如(北京):110101
	 * @param extensionsValue
	 *            气象类型,可选值：base/all,base:返回实况天气,all:返回预报天气
	 * @param outputValue
	 *            返回格式,可选值：JSON,XML,默认:JSON
	 */
	private static void initParams(String cityAdcodeValue,
			String extensionsValue, String outputValue) {
		key = "key=KEY";
		city = "city=CITY";
		extensions = "extensions=EXTENSIONS";
		output = "output=OUTPUT";
		HTTP_ARG = new StringBuffer();
		initData(cityAdcodeValue, extensionsValue, outputValue);
	}

	/**
	 * @param cityAdcodeValue
	 *            例如(北京):110101
	 * @param extensionsValue
	 *            气象类型,可选值：base/all,base:返回实况天气,all:返回预报天气
	 * @param outputValue
	 *            返回格式,可选值：JSON,XML,默认:JSON
	 */
	private static void initData(String cityAdcodeValue,
			String extensionsValue, String outputValue) {
		key = key.replace("KEY", KEY);
		HTTP_ARG.append(key);
		if (cityAdcodeValue != null && !"".equalsIgnoreCase(cityAdcodeValue)) {
			city = city.replace("CITY", cityAdcodeValue);
			HTTP_ARG.append("&");
			HTTP_ARG.append(city);
		}
		if (extensionsValue != null && !"".equalsIgnoreCase(extensionsValue)) {
			extensions = extensions.replace("EXTENSIONS", extensionsValue);
			HTTP_ARG.append("&");
			HTTP_ARG.append(extensions);
		}
		if (outputValue != null && !"".equalsIgnoreCase(outputValue)) {
			output = output.replace("OUTPUT", outputValue);
			HTTP_ARG.append("&");
			HTTP_ARG.append(outputValue);
		}
	}

	/**
	 * 根据城市名编码获取天气
	 * 
	 * @param cityAdcodeValue
	 *            例如(北京):110101
	 * @param extensionsValue
	 *            气象类型,可选值：base/all,base:返回实况天气,all:返回预报天气
	 * @param outputValue
	 *            返回格式,可选值：JSON,XML,默认:JSON
	 * @return
	 */
	public static WeatherInfo getWeatherInfo(String cityAdcodeValue,
			String extensionsValue, String outputValue) {
		WeatherInfo weatherInfo = null;
		initParams(cityAdcodeValue, extensionsValue, outputValue);
		// 发送请求后就得到了json字符串
		String jsonStr = HttpRequestAmapUtil.request(HTTP_URL,
				HTTP_ARG.toString());
		// JSON的核心代码
		Gson gson = new GsonBuilder().create();
		try {
			// 这里会自动将Unicode编码转为中文
			weatherInfo = gson.fromJson(jsonStr, WeatherInfo.class);
		} catch (Exception e) {

		}
		return weatherInfo;
	}

	/**
	 * 根据经纬度获取天气,这里调用高德地图提供的逆地理编码(根据经纬度获取城市)的方法
	 * 
	 * @param latitude
	 *            纬度,x,"24.482438"
	 * @param longitude
	 *            经度,y,"118.184064"
	 * @param extensionsValue
	 *            气象类型,可选值：base/all,base:返回实况天气,all:返回预报天气
	 * @param outputValue
	 *            返回格式,可选值：JSON,XML,默认:JSON
	 * @return
	 */
	public static WeatherInfo getWeatherInfoFromGeo(String latitude,
			String longitude, String extensionsValue, String outputValue) {
		WeatherInfo weatherInfo = null;
		LocationInfo locationInfo = LocationUtil.getLocationInfo(latitude,
				longitude);
		String cityAdcodeValue = locationInfo.getRegeocodes()
				.getAddressComponent().getAdcode();
		weatherInfo = getWeatherInfo(cityAdcodeValue, extensionsValue,
				outputValue);
		return weatherInfo;
	}

	public static void main(String[] args) {
		// WeatherInfo weatherInfo = getWeatherInfo("厦门");
		// WeatherInfo weatherInfo = getWeatherInfoFromIp(null);
		// System.out.println(weatherInfo.toString());

		// 厦门
		String latitude = "24.476170";
		String longitude = "118.177528";
		WeatherInfo weatherInfo = getWeatherInfoFromGeo(latitude, longitude,
				null, null);
		System.out.println(weatherInfo.toString());
	}

}
