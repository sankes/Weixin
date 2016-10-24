package com.shankes.amap.weather.domain;

public class WeatherLive {

	private String province;// 省份名
	private String city;// 城市名
	private long adcode;// 区域编码
	private String weather;// 天气现象，天气现象对应描述
	private int temperature;// 实时气温，单位：摄氏度
	private String winddirection;// 风向，风向编码对应描述
	private int windpower;// 风力，风力编码对应风力级别，单位：级
	private int humidity;// 空气湿度
	private String reporttime;// 数据发布的时间

	@Override
	public String toString() {
		return "WeatherLive [province=" + province + ", city=" + city
				+ ", adcode=" + adcode + ", weather=" + weather
				+ ", temperature=" + temperature + ", winddirection="
				+ winddirection + ", windpower=" + windpower + ", humidity="
				+ humidity + ", reporttime=" + reporttime + "]";
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getAdcode() {
		return adcode;
	}

	public void setAdcode(long adcode) {
		this.adcode = adcode;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public String getWinddirection() {
		return winddirection;
	}

	public void setWinddirection(String winddirection) {
		this.winddirection = winddirection;
	}

	public int getWindpower() {
		return windpower;
	}

	public void setWindpower(int windpower) {
		this.windpower = windpower;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public String getReporttime() {
		return reporttime;
	}

	public void setReporttime(String reporttime) {
		this.reporttime = reporttime;
	}
}
