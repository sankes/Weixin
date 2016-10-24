package com.shankes.message.req;

import java.util.Map;

/**
 * 链接消息
 * 
 * @author shankes
 * @date 2016-08-19
 */
public class LinkMessageReq extends BaseMessageReq {
	// 消息标题
	private String Title;
	// 消息描述
	private String Description;
	// 消息链接
	private String Url;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}
	public static LinkMessageReq getLinkMessageReq(Map<String,String> map){
		LinkMessageReq linkMessageReq = new LinkMessageReq();
		linkMessageReq.setToUserName(map.get("ToUserName"));// 开发者微信号
		linkMessageReq.setFromUserName(map.get("FromUserName"));// 发送方帐号（一个OpenID）
		linkMessageReq.setCreateTime(Long.valueOf(map.get("CreateTime")));// 消息创建时间 （整型）
		linkMessageReq.setMsgType(map.get("MsgType"));// 1 text,2 image,3 voice,4 video,5 shortvideo,6 location,7 link
		linkMessageReq.setMsgId(Long.valueOf(map.get("MsgId")));// 消息id，64位整型 
		linkMessageReq.setTitle(map.get("Title"));
		linkMessageReq.setDescription(map.get("Description"));
		linkMessageReq.setUrl(map.get("Url"));
		return linkMessageReq;
	}
}
