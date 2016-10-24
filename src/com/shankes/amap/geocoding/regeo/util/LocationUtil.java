package com.shankes.amap.geocoding.regeo.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shankes.amap.geocoding.regeo.domain.LocationInfo;
import com.shankes.amap.util.HttpRequestAmapUtil;

public class LocationUtil {
	private static String HTTP_URL = "http://restapi.amap.com/v3/geocode/regeo";
	// *用户在高德地图官网申请Web服务API类型KEY
	private static final String KEY = "7234a23caa0795211ae041e96f3c7b5d";
	// 请求服务权限标识
	private static String key = "key=KEY";// 用户在高德地图官网申请Web服务API类型KEY
	// * 经纬度坐标
	private static String location = "location=LOCATION";// 规则：最多支持20个坐标点。多个点之间用"|"分割。经度在前，纬度在后，经纬度间以“，”分割，经纬度小数点后不得超过6位
	// 返回附近POI类型
	private static String poitype = "poitype=POITYPE";// 支持传入POITYPECODE及名称；支持传入多个POI类型，多值间用“|”分隔，extensions=all时生效，不支持batch=true(逆地理编码批量查询),默认值：1000
	// 搜索半径
	private static String radius = "radius=RADIUS";// 取值范围：0~3000,单位：米,默认为：1000
	// 返回结果控制
	private static String extensions = "extensions=EXTENSIONS";// 此项默认返回基本地址信息；取值为all返回地址信息、附近POI、道路以及道路交叉口信息。默认：base
	// 批量查询控制
	private static String batch = "batch=BATCH";// batch=true为批量查询。batch=false为单点查询，batch=false时即使传入多个点也只返回第一个点结果,默认：false
	// 道路等级
	private static String roadlevel = "roadlevel=ROADLEVEL";// 可选值：1，当roadlevel=1时，过滤非主干道路，仅输出主干道路数据
	// 数字签名
	private static String sig = "sig=SIG";// 数字签名获取和使用方法
	// 返回数据格式类型
	private static String output = "output=OUTPUT";// 可选值：JSON,XML,默认：JSON
	// 回调函数
	private static String callback = "callback=CALLBACK";// callback值是用户定义的函数名称，此参数只在output=JSON时有效
	// 是否优化POI返回顺序
	// 0：不优化。
	// 1：综合大数据将居家相关的主POI结果优先返回，即优化pois字段之中的poi顺序。
	// 2：综合大数据将公司相关的主POI结果优先返回，即优化pois字段之中的poi顺序。
	private static String homeorcorp = "homeorcorp=HOMEORCORP";// 可选参数:0,1,2,默认:0
	// 拼接参数
	private static StringBuffer HTTP_ARG = new StringBuffer();

	/**
	 * 逆地理编码
	 * 
	 * @param latitude
	 *            纬度,x,"24.482438"
	 * @param longitude
	 *            经度,y,"118.184064"
	 * @return
	 */
	public static LocationInfo getLocationInfo(String latitude, String longitude) {
		LocationInfo locationInfo = null;
		HTTP_ARG = new StringBuffer();
		// TODO 这里暂时只拼接两个必须的参数
		HTTP_ARG.append(key);
		HTTP_ARG.append("&");
		HTTP_ARG.append(location);
		String httpArg = HTTP_ARG.toString().replace("KEY", KEY);
		// 经度在前，纬度在后，经纬度间以“,”分割
		httpArg = httpArg.replace("LOCATION", longitude + "," + latitude);
		// 发送请求后就得到了json字符串
		// httpArg =
		// "key=7234a23caa0795211ae041e96f3c7b5d&location=116.481488,39.990464&poitype=商务写字楼&radius=1000&extensions=all&batch=false&roadlevel=1";
		String jsonStr = HttpRequestAmapUtil.request(HTTP_URL, httpArg);
		jsonStr = jsonStr.replace("[]", "\"\"");
		jsonStr = jsonStr.replace("[\"\"]", "[{}]");

		// JSON的核心代码
		// Gson gson = new GsonBuilder().create();
		Gson gson = new GsonBuilder().serializeNulls().create();
		try {
			locationInfo = gson.fromJson(jsonStr, LocationInfo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return locationInfo;
	}

	public static void main(String[] args) {

		// 厦门
		String latitude = "24.476170";
		String longitude = "118.177528";
		// 海外,城市名为空
		// String latitude = "148.947917";
		// String longitude = "16.76727";

		LocationInfo locationInfo = getLocationInfo(latitude, longitude);
		System.out.println("--" + locationInfo.getRegeocodes().getAddressComponent().getCity() + "--");
	}

}
