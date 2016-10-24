package com.shankes.baidu.iplocation.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shankes.baidu.iplocation.domain.IpLocationInfo;

public class IpLocationUtil {

	private static String HTTP_URL = "http://api.map.baidu.com/location/ip";
	private static String AK = "7sqA81OWkmxg20kWEGb5idInSj71pCG1";
	// ip地址
	private static String ip = "ip=IP";// 可选，ip不出现，或者出现且为空字符串的情况下，会使用当前访问者的IP地址作为定位参数
	// * 用户密钥
	private static String ak = "ak=AK";// 必选，在lbs云官网注册的access key，作为访问的依据
	// 用户的权限签名
	private static String sn = "sn=SN";// 可选，若用户所用ak的校验方式为sn校验时该参数必须。（sn生成算法）
	// 输出的坐标格式
	private static String coor = "coor=COOR";// 可选，coor不出现时，默认为百度墨卡托坐标；coor=bd09ll时，返回为百度经纬度坐标

	// 拼接参数
	private static StringBuffer HTTP_ARG = new StringBuffer();

	/**
	 * 根据ip获取位置
	 *
	 * @param ipValue
	 *            空值,默认为当前主机ip,"222.76.241.234";
	 * @return
	 */
	public static IpLocationInfo getIpLocationInfo(String ipValue) {
		IpLocationInfo ipLocationInfo = null;
		HTTP_ARG = new StringBuffer();
		// TODO 这里暂时只拼接两个必须的参数
		ak = ak.replace("AK", AK);
		HTTP_ARG.append(ak);
		if (ipValue != null && !"".equalsIgnoreCase(ipValue)) {
			ip = ip.replace("IP", ipValue);
			HTTP_ARG.append("&");
			HTTP_ARG.append(ip);
		}
		String jsonStr = HttpRequestUtil.request(HTTP_URL, HTTP_ARG.toString());
		Gson gson = new GsonBuilder().create();
		try {
			ipLocationInfo = gson.fromJson(jsonStr, IpLocationInfo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ipLocationInfo;
	}

	public static void main(String[] args) {
		String ipValue = "";// 空值,默认为当前主机ip
		// String ipValue = "120.27.131.71";
		// String ipValue = "222.76.241.234";
		IpLocationInfo ipLocationInfo = getIpLocationInfo(ipValue);
		System.out.println("--" + ipLocationInfo.toString() + "--");
	}
}
