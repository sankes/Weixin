package com.shankes.turing.domain;

/**
 * 100000 文本类
 * 
 * 200000 链接类
 * 
 * 302000 新闻类
 * 
 * 308000 菜谱类
 * 
 * 313000 （儿童版） 儿歌类
 * 
 * 314000 （儿童版） 诗词类
 * 
 * 异常码（ code ） 说明
 * 
 * 40001 参数 key 错误
 * 
 * 40002 请求内容 info 为空
 * 
 * 40004 当天请求次数已使用完
 * 
 * 40007 数据格式异常
 * 
 * @author shankes
 *
 */
public class TuringBaseInfo {
	private String code;
	private String text;

	@Override
	public String toString() {
		return "TuringInfo [code=" + code + ", text=" + text + "]";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
