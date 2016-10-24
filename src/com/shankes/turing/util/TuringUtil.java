package com.shankes.turing.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shankes.baidu.iplocation.util.HttpRequestUtil;
import com.shankes.turing.domain.TuringBaseInfo;

/**
 * 图灵机器人
 * 
 * @author shankes
 * 
 * @api:http://www.tuling123.com
 */
public class TuringUtil {
	private static String HTTP_URL = "http://www.tuling123.com/openapi/api";
	private static String APIKEY = "6643ca3bfca140f7af3ffea15d8122bd";

	// * 注册之后在机器人接入页面获得
	private static String key;// * APIKEY
	// * 请求内容，编码方式为UTF-8长度1-30
	private static String info;// * 今天天气怎么样
	private static String loc;// 北京市中关村”，
	// 开发者给自己的用户分配的唯一标志（对应自己的每一个用户）
	// abc123（支持0-9，a-z,A-Z组合，不能包含特殊字符）
	private static String userid;// 123456

	// 拼接参数
	private static StringBuffer HTTP_ARG = null;

	private static void init(String infoValue, String locValue,
			String useridValue) {
		key = "key=KEY";
		info = "info=INFO";
		loc = "loc=LOC";
		userid = "userid=USERID";
		HTTP_ARG = new StringBuffer();

		// 1.key
		key = key.replace("KEY", APIKEY);
		HTTP_ARG.append(key);

		// 2.info
		info = info.replace("INFO", infoValue.trim());
		HTTP_ARG.append("&");
		HTTP_ARG.append(info);

		// 3.loc
		if (locValue != null && !"".equals(locValue.trim())) {
			loc = loc.replace("LOC", locValue.trim());
			HTTP_ARG.append("&");
			HTTP_ARG.append(loc);
		}// 4.userid
		if (useridValue != null && !"".equals(useridValue.trim())) {
			userid = userid.replace("USERID", useridValue.trim());
			HTTP_ARG.append("&");
			HTTP_ARG.append(userid);
		}

	}

	/**
	 * @param infoValue
	 *            请求内容，编码方式为UTF-8长度1-30,例如:今天天气怎么样
	 * @param useridValue
	 *            开发者给自己的用户分配的唯一标志（对应自己的每一个用户）
	 * @return
	 */
	private static String geTuringString(String infoValue, String locValue,
			String useridValue) {
		init(infoValue, locValue, useridValue);
		String turingString = null;
		turingString = HttpRequestUtil.request(HTTP_URL, HTTP_ARG.toString());
		return turingString;
	}

	/**
	 * @param infoValue
	 *            请求内容，编码方式为UTF-8长度1-30,例如:今天天气怎么样
	 * @param useridValue
	 *            开发者给自己的用户分配的唯一标志（对应自己的每一个用户）
	 * @return
	 */
	public static TuringBaseInfo geTuringInfo(String infoValue, String locValue,
			String useridValue) {
		init(infoValue, locValue, useridValue);
		TuringBaseInfo turingInfo = null;
		String jsonStr = geTuringString(infoValue, locValue, useridValue);
		Gson gson = new GsonBuilder().create();
		try {
			turingInfo = gson.fromJson(jsonStr, TuringBaseInfo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return turingInfo;
	}

	public static void main(String[] args) {
		String infoValue = "今天天气怎么样";
		String locValue = "北京中关村";
		String useridValue = "shankes";
		TuringBaseInfo turingInfo = TuringUtil.geTuringInfo(infoValue, locValue,
				useridValue);

		System.out.println(turingInfo.toString());
	}
}