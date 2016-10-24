package com.shankes.weixin.util;

import java.util.Arrays;

import com.shankes.util.EncryptUtil;

public class CheckUtil {

	private static String token = "shankes";

	/**
	 * @param signature
	 *            微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
	 * @param timestamp
	 *            时间戳
	 * @param nonce
	 *            随机数
	 * @return
	 */
	public static boolean checkSignature(String signature, String timestamp, String nonce) {
		// 1将token、timestamp、nonce三个参数进行字典序排序，拼接成一个字符串
		String[] arr = new String[] { token, timestamp, nonce };
		Arrays.sort(arr);
		StringBuffer content = new StringBuffer();
		for (String string : arr) {
			content.append(string);
		}
		// 2）将拼接成的字符串进行sha1加密
		String temp = EncryptUtil.getSha1(content.toString());
		// 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
		return temp.equals(signature);
	}
}
