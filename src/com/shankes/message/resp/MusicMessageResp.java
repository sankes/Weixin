package com.shankes.message.resp;

/**
 * 音乐消息
 * 
 * @author shankes
 * @date 2016-08-19
 */
public class MusicMessageResp extends BaseMessageResp {
	// 音乐
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}
