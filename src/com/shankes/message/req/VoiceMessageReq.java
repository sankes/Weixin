package com.shankes.message.req;

import java.util.Map;

/**
 * 音频消息
 * 
 * @author shankes
 * @date 2016-08-19
 */
public class VoiceMessageReq extends BaseMessageReq {
	// 媒体ID
	private String MediaId;
	// 语音格式
	private String Format;
	
	public static VoiceMessageReq getVoiceMessageReq(Map<String,String> map){
		VoiceMessageReq voiceMessageReq = new VoiceMessageReq();
		voiceMessageReq.setToUserName(map.get("ToUserName"));// 开发者微信号
		voiceMessageReq.setFromUserName(map.get("FromUserName"));// 发送方帐号（一个OpenID）
		voiceMessageReq.setCreateTime(Long.valueOf(map.get("CreateTime")));// 消息创建时间 （整型）
		voiceMessageReq.setMsgType(map.get("MsgType"));// 1 text,2 image,3 voice,4 video,5 shortvideo,6 location,7 link
		voiceMessageReq.setMsgId(Long.valueOf(map.get("MsgId")));// 消息id，64位整型 
		voiceMessageReq.setMediaId(map.get("MediaId"));
		voiceMessageReq.setFormat(map.get("Format"));
		return voiceMessageReq;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}
}
