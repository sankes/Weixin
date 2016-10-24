package com.shankes.message.req;

import java.util.Map;

/**
 * 图片消息
 * 
 * @author shankes
 * @date 2016-08-19
 */
public class ImageMessageReq extends BaseMessageReq {
	// 图片链接
	private String PicUrl;
	
	public static ImageMessageReq getImageMessageReq(Map<String,String> map){
		ImageMessageReq imageMessageReq = new ImageMessageReq();
		imageMessageReq.setToUserName(map.get("ToUserName"));// 开发者微信号
		imageMessageReq.setFromUserName(map.get("FromUserName"));// 发送方帐号（一个OpenID）
		imageMessageReq.setCreateTime(Long.valueOf(map.get("CreateTime")));// 消息创建时间 （整型）
		imageMessageReq.setMsgType(map.get("MsgType"));// 1 text,2 image,3 voice,4 video,5 shortvideo,6 location,7 link
		imageMessageReq.setMsgId(Long.valueOf(map.get("MsgId")));// 消息id，64位整型 
		imageMessageReq.setPicUrl(map.get("PicUrl"));
		return imageMessageReq;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
}
