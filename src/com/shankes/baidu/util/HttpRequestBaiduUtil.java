package com.shankes.baidu.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestBaiduUtil {
	// 参考地址:http://apistore.baidu.com/apiworks/servicedetail/112.html

	public static final String APIKEY = "9940f7550db411f7dea7acf00a10bb93";

	/**
	 * @param httpUrl
	 *            请求接口
	 * @param httpArg
	 *            参数
	 * @return
	 */
	public static String request(String httpUrl, String httpArg) {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		httpUrl = httpUrl + "?" + httpArg;

		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			// 填入apikey到HTTP header
			connection.setRequestProperty("apikey", APIKEY);
			connection.setRequestProperty("responsecode", "302");
			connection.connect();
			int responseCode = connection.getResponseCode();
			System.out.println(responseCode);
			System.out.println(connection.getResponseMessage());
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
