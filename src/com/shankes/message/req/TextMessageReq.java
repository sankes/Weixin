package com.shankes.message.req;

import java.util.Map;

/**
 * 文本消息
 * 
 * @author shankes
 * @date 2016-08-19
 */
public class TextMessageReq extends BaseMessageReq {
	// 消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
	public static TextMessageReq getTextMessageReq(Map<String,String> map){
		TextMessageReq textMessageReq = new TextMessageReq();
		textMessageReq.setToUserName(map.get("ToUserName"));// 开发者微信号
		textMessageReq.setFromUserName(map.get("FromUserName"));// 发送方帐号（一个OpenID）
		textMessageReq.setCreateTime(Long.valueOf(map.get("CreateTime")));// 消息创建时间 （整型）
		textMessageReq.setMsgType(map.get("MsgType"));// 1 text,2 image,3 voice,4 video,5 shortvideo,6 location,7 link
		textMessageReq.setMsgId(Long.valueOf(map.get("MsgId")));// 消息id，64位整型 
		textMessageReq.setContent(map.get("Content"));
		return textMessageReq;
	}
}