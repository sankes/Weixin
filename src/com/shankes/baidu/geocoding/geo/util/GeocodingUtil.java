package com.shankes.baidu.geocoding.geo.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shankes.baidu.geocoding.geo.domain.GeocodingInfo;
import com.shankes.baidu.iplocation.util.HttpRequestUtil;

public class GeocodingUtil {
	private static String HTTP_URL = "http://api.map.baidu.com/geocoder/v2/";
	private static String AK = "7sqA81OWkmxg20kWEGb5idInSj71pCG1";
//	private static String AK = "9940f7550db411f7dea7acf00a10bb93";

	private static String output = "output=OUTPUT";// json或xml,输出格式为json或者xml(默认:xml)
	// 用户申请注册的key，自v2开始参数修改为“ak”，之前版本参数为“key”
	// TODO * E4805d16520de693a3fe707cdc962045
	private static String ak = "ak=AK";
	private static String sn = "sn=SN";// 若用户所用ak的校验方式为sn校验时该参数必须。 （sn生成算法）
	// callback=showLocation(JavaScript函数名)
	// 将json格式的返回值通过callback函数返回以实现jsonp功能
	private static String callback = "callback=CALLBACK";
	// 根据指定地址进行坐标的反定向解析，最多支持100个字节输入。
	// 可以输入三种样式的值，分别是：
	// 1、标准的地址信息，如北京市海淀区上地十街十号
	// 2、名胜古迹、标志性建筑物，如天安门，百度大厦
	// 3、支持“*路与*路交叉口”描述方式，如北一环路和阜阳路的交叉路口
	// 注意：后两种方式并不总是有返回结果，只有当地址库中存在该地址描述时才有返回。
	// TODO * 北京市海淀区上地十街10号
	private static String address = "address=ADDRESS";

	// 地址所在的城市名。用于指定上述地址所在的城市，当多个城市都有上述地址时，该参数起到过滤作用。
	private static String city = "city=CITY";// “北京市” “广州市”

	// 拼接参数
	private static StringBuffer HTTP_ARG = new StringBuffer();

	/**
	 * 地理编码服务
	 * 
	 * @param address
	 * @return
	 */
	public static GeocodingInfo getGeocodingInfo(String addressValue,String cityValue) {
		GeocodingInfo geocodingInfo = null;
		HTTP_ARG = new StringBuffer();
		// TODO 这里暂时只拼接两个必须的参数
		ak = ak.replace("AK",AK);
		HTTP_ARG.append(ak);
		output = output.replace("OUTPUT","json");
		HTTP_ARG.append("&");
		HTTP_ARG.append(output);
		if (addressValue != null && !"".equalsIgnoreCase(addressValue)) {
			address = address.replace("ADDRESS", addressValue);
			HTTP_ARG.append("&");
			HTTP_ARG.append(address);
		}
		if (cityValue != null && !"".equalsIgnoreCase(cityValue)) {
			city = city.replace("CITY", cityValue);
			HTTP_ARG.append("&");
			HTTP_ARG.append(city);
		}
		String jsonStr = HttpRequestUtil.request(HTTP_URL, HTTP_ARG.toString());
		Gson gson = new GsonBuilder().create();
		try {
			geocodingInfo = gson.fromJson(jsonStr, GeocodingInfo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return geocodingInfo;
	}

	public static void main(String[] args) {
		String addressValue = "前埔";
		String cityValue = "厦门";
		GeocodingInfo geocodingInfo = getGeocodingInfo(addressValue,cityValue);
		System.out.println("--" + geocodingInfo.toString() + "--");
	}
}
