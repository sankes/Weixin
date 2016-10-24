package com.shankes.weixin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.shankes.amap.geocoding.regeo.domain.LocationInfo;
import com.shankes.amap.geocoding.regeo.util.LocationUtil;
import com.shankes.baidu.weather.domain.WeatherInfo;
import com.shankes.baidu.weather.util.WeatherUtil;
import com.shankes.message.req.BaseMessageReq;
import com.shankes.message.req.LocationMessageReq;
import com.shankes.message.req.TextMessageReq;
import com.shankes.message.resp.TextMessageResp;
import com.shankes.util.XmlUtil;
import com.shankes.weixin.util.CheckUtil;
import com.shankes.weixin.util.MessageUtil;

/**
 * Servlet implementation class WeixinServlet
 */
// @WebServlet(description = "微信", urlPatterns = { "/WeixinServlet" })
@WebServlet(description = "微信", urlPatterns = { "/wx.do" })
public class WeixinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WeixinServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String signature = request.getParameter("signature");// 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
		String timestamp = request.getParameter("timestamp");// 时间戳
		String nonce = request.getParameter("nonce");// 随机数
		String echostr = request.getParameter("echostr");// 随机字符串

		System.out.println("接收到get请求");
		PrintWriter out = response.getWriter();
		if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Map<String, String> map = XmlUtil.xmlToMap(request);
			BaseMessageReq baseMessageReq = new BaseMessageReq();
			baseMessageReq.setToUserName(map.get("ToUserName"));// 开发者微信号
			baseMessageReq.setFromUserName(map.get("FromUserName"));// 发送方帐号（一个OpenID）
			baseMessageReq.setCreateTime(Long.valueOf(map.get("CreateTime")));// 消息创建时间
																				// （整型）
			baseMessageReq.setMsgType(map.get("MsgType"));// 1 text,2 image,3
															// voice,4 video,5
															// shortvideo,6
															// location,7 link
			baseMessageReq.setMsgId(Long.valueOf(map.get("MsgId")));// 消息id，64位整型

			String msgResp = "";
			if (MessageUtil.REQ_MESSAGE_TYPE_TEXT.equals(baseMessageReq
					.getMsgType())) {// 1.文本消息
				// 接收到的文本消息
				TextMessageReq textMessageReq = TextMessageReq
						.getTextMessageReq(map);
				String contentResp = "";
				WeatherInfo weatherInfo = WeatherUtil.getWeatherInfo(map
						.get("Content"));
				if (weatherInfo != null) {
					contentResp = weatherInfo.toStringFormat();
				} else {
					contentResp = "你发送的消息内容是:" + textMessageReq.getContent();
				}
				TextMessageResp textMessageResp = TextMessageResp
						.getTextMessageResp(map, contentResp);
				msgResp = MessageUtil.textMessageToXml(textMessageResp);
			} else if (MessageUtil.REQ_MESSAGE_TYPE_IMAGE.equals(baseMessageReq
					.getMsgType())) {// 2.图片消息
				// ImageMessageReq imageMessageReq =
				// ImageMessageReq.getImageMessageReq(map);

			} else if (MessageUtil.REQ_MESSAGE_TYPE_VOICE.equals(baseMessageReq
					.getMsgType())) {// 3.语音消息
				// VoiceMessageReq voiceMessageReq =
				// VoiceMessageReq.getVoiceMessageReq(map);

			} else if (MessageUtil.REQ_MESSAGE_TYPE_VIDEO.equals(baseMessageReq
					.getMsgType())) {// 4.视频消息

			} else if (MessageUtil.REQ_MESSAGE_TYPE_SHORT_VIDEO
					.equals(baseMessageReq.getMsgType())) {// 5.小视频消息

			} else if (MessageUtil.REQ_MESSAGE_TYPE_LOCATION
					.equals(baseMessageReq.getMsgType())) {// 6.地理位置消息
				LocationMessageReq locationMessageReq = LocationMessageReq
						.getLocationMessageReq(map);
				// 这里暂时回复该位置的天气
				LocationInfo locationInfo = LocationUtil.getLocationInfo(
						locationMessageReq.getLocation_X(),
						locationMessageReq.getLocation_Y());
				String city = locationInfo.getRegeocodes()
						.getAddressComponent().getCity();
				String contentResp = "";
				if (city != null && !"".equalsIgnoreCase(city)) {
					city = city.replace("市", "");
					WeatherInfo weatherInfo = WeatherUtil.getWeatherInfo(city);
					if (weatherInfo != null) {
						contentResp = weatherInfo.toStringFormat();
					} else {
						contentResp = "你发送的位置经纬度为:"
								+ locationMessageReq.getLocation_X() + ","
								+ locationMessageReq.getLocation_Y();
					}
					TextMessageResp textMessageResp = TextMessageResp
							.getTextMessageResp(map, contentResp);
					msgResp = MessageUtil.textMessageToXml(textMessageResp);
				}
			} else if (MessageUtil.REQ_MESSAGE_TYPE_LINK.equals(baseMessageReq
					.getMsgType())) {// 7.链接消息
				// LinkMessageReq linkMessageReq =
				// LinkMessageReq.getLinkMessageReq(map);

			}
			out.print(msgResp);
			System.out.println(msgResp);
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
}
