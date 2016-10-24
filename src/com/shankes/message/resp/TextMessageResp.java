package com.shankes.message.resp;

import java.util.Map;

import com.shankes.util.DateUtil;

/**
 * 文本消息
 * 
 * @author shankes
 * @date 2016-08-19
 */
public class TextMessageResp extends BaseMessageResp {
	// 回复的消息内容
	private String Content;
	
	public static TextMessageResp getTextMessageResp(Map<String,String> map,String contentResp){
		TextMessageResp textMessageResp = new TextMessageResp();
		textMessageResp.setToUserName(map.get("FromUserName"));// 开发者微信号
		textMessageResp.setFromUserName(map.get("ToUserName"));// 发送方帐号（一个OpenID）
		textMessageResp.setCreateTime(DateUtil.getTime());// 消息创建时间 （整型）
		textMessageResp.setMsgType("text");// 1 text,2 image,3 voice,4 video,5 shortvideo,6 location,7 link
		textMessageResp.setContent(contentResp);
		return textMessageResp;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
