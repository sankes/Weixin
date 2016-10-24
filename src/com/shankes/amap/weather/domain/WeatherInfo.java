package com.shankes.amap.weather.domain;

import java.util.List;

public class WeatherInfo {
	private int status;// 返回状态,值为0或1,1：成功；0：失败
	private int count;// 返回结果总数目
	private String info;// 返回的状态信息
	private long infocode;// 返回状态说明,1000代表正确
	private List<WeatherLive> lives;// 实况天气数据信息
	private WeatherForecast forecast;// 预报天气信息数据

	@Override
	public String toString() {
		return "WeatherInfo [status=" + status + ", count=" + count + ", info="
				+ info + ", infocode=" + infocode + ", lives=" + lives
				+ ", forecast=" + forecast + "]";
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public long getInfocode() {
		return infocode;
	}

	public void setInfocode(long infocode) {
		this.infocode = infocode;
	}

	public List<WeatherLive> getLives() {
		return lives;
	}

	public void setLives(List<WeatherLive> lives) {
		this.lives = lives;
	}

	public WeatherForecast getForecast() {
		return forecast;
	}

	public void setForecast(WeatherForecast forecast) {
		this.forecast = forecast;
	}
}
