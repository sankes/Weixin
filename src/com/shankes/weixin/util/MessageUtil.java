package com.shankes.weixin.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.shankes.message.resp.Article;
import com.shankes.message.resp.MusicMessageResp;
import com.shankes.message.resp.NewsMessageResp;
import com.shankes.message.resp.TextMessageResp;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * 消息工具类
 * 
 * @author shankes
 * @date 2016-08-19
 */
public class MessageUtil {
	/**
	 * 返回消息类型：文本
	 */
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 返回消息类型：音乐
	 */
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";

	/**
	 * 返回消息类型：图文
	 */
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";

	/**
	 * 请求消息类型：文本
	 */
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 请求消息类型：图片
	 */
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

	/**
	 * 请求消息类型：语音
	 */
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";

	/**
	 * 请求消息类型：视频
	 */
	public static final String REQ_MESSAGE_TYPE_VIDEO = "video";

	/**
	 * 请求消息类型：小视频
	 */
	public static final String REQ_MESSAGE_TYPE_SHORT_VIDEO = "shortvideo";

	/**
	 * 请求消息类型：地理位置
	 */
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";

	/**
	 * 请求消息类型：链接
	 */
	public static final String REQ_MESSAGE_TYPE_LINK = "link";

	/**
	 * 请求消息类型：推送
	 */
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";

	/**
	 * 事件类型：subscribe(订阅)
	 */
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

	/**
	 * 事件类型：unsubscribe(取消订阅)
	 */
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

	/**
	 * 事件类型：CLICK(自定义菜单点击事件)
	 */
	public static final String EVENT_TYPE_CLICK = "CLICK";

	/**
	 * 文本消息对象转换成xml
	 * 
	 * @param textMessageResp
	 *            文本消息对象
	 * @return xml
	 */
	public static String textMessageToXml(TextMessageResp textMessageResp) {
		xstream.alias("xml", textMessageResp.getClass());
		return xstream.toXML(textMessageResp);
	}

	/**
	 * 音乐消息对象转换成xml
	 * 
	 * @param musicMessageResp
	 *            音乐消息对象
	 * @return xml
	 */
	public static String musicMessageToXml(MusicMessageResp musicMessageResp) {
		xstream.alias("xml", musicMessageResp.getClass());
		return xstream.toXML(musicMessageResp);
	}

	/**
	 * 图文消息对象转换成xml
	 * 
	 * @param newsMessageResp
	 *            图文消息对象
	 * @return xml
	 */
	public static String newsMessageToXml(NewsMessageResp newsMessageResp) {
		xstream.alias("xml", newsMessageResp.getClass());
		xstream.alias("item", new Article().getClass());
		return xstream.toXML(newsMessageResp);
	}

	/**
	 * 扩展xstream，使其支持CDATA块
	 * 
	 * @date 2016-08-19
	 */
	private static XStream xstream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有xml节点的转换都增加CDATA标记
				boolean cdata = true;

				@SuppressWarnings("rawtypes")
				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
				}

				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});
}
