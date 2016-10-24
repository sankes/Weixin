package com.shankes.message.req;

import java.util.Map;

/**
 * 地理位置消息
 * 
 * @author shankes
 * @date 2016-08-19
 */
public class LocationMessageReq extends BaseMessageReq {
	// 地理位置维度
	private String Location_X;
	// 地理位置经度
	private String Location_Y;
	// 地图缩放大小
	private String Scale;
	// 地理位置信息
	private String Label;
	
	public static LocationMessageReq getLocationMessageReq(Map<String,String> map){
		LocationMessageReq locationMessageReq = new LocationMessageReq();
		locationMessageReq.setToUserName(map.get("ToUserName"));// 开发者微信号
		locationMessageReq.setFromUserName(map.get("FromUserName"));// 发送方帐号（一个OpenID）
		locationMessageReq.setCreateTime(Long.valueOf(map.get("CreateTime")));// 消息创建时间 （整型）
		locationMessageReq.setMsgType(map.get("MsgType"));// 1 text,2 image,3 voice,4 video,5 shortvideo,6 location,7 link
		locationMessageReq.setMsgId(Long.valueOf(map.get("MsgId")));// 消息id，64位整型 
		locationMessageReq.setLocation_X(map.get("Location_X"));
		locationMessageReq.setLocation_Y(map.get("Location_Y"));
		locationMessageReq.setScale(map.get("Scale"));
		locationMessageReq.setLabel(map.get("Label"));
		return locationMessageReq;
	}

	public String getLocation_X() {
		return Location_X;
	}

	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}

	public String getLocation_Y() {
		return Location_Y;
	}

	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}

	public String getScale() {
		return Scale;
	}

	public void setScale(String scale) {
		Scale = scale;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}
}
