package com.shankes.baidu.weather.domain;

public class WeatherData {

	private String city;// 城市,北京,"接口已经停用"
	private String pinyin; // 城市拼音,beijing
	private String citycode; // 城市编码,101010100
	private String date; // 日期,15-02-11
	private String time; // 发布时间,11:00
	private String postCode; // 邮编,100000
	private String longitude; // 经度,116.391
	private String latitude; // 维度,39.904
	private String altitude; // 海拔,33
	private String weather; // 天气情况,晴
	private String temp; // 气温,10
	private String l_tmp; // 最低气温,-4
	private String h_tmp; // 最高气温,10
	private String WD; // 风向,无持续风向
	private String WS; // 风力,微风(<10m/h),"接口已经停用，请访问APIStore.baidu.com查找对应接口",
	private String sunrise; // 日出时间,07:12
	private String sunset; // 日落时间,17:44

	@Override
	public String toString() {
		return "WeatherData [city=" + city + ", pinyin=" + pinyin + ", citycode=" + citycode + ", date=" + date
				+ ", time=" + time + ", postCode=" + postCode + ", longitude=" + longitude + ", latitude=" + latitude
				+ ", altitude=" + altitude + ", weather=" + weather + ", temp=" + temp + ", l_tmp=" + l_tmp
				+ ", h_tmp=" + h_tmp + ", WD=" + WD + ", WS=" + WS + ", sunrise=" + sunrise + ", sunset=" + sunset
				+ "]";
	}

	public String toStringFormat() {
		return "地区:" + city + "\n日期:" + date + "\n时间:" + time + "\n邮编:" + postCode + "\n天气:" + weather + "\n气温:" + temp
				+ "\n最低气温:" + l_tmp + "\n最高气温:" + h_tmp + "\n风向:" + WD + "\n风力:" + WS + "\n日出时间:" + sunrise + "\n日落时间:"
				+ sunset;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getAltitude() {
		return altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getL_tmp() {
		return l_tmp;
	}

	public void setL_tmp(String l_tmp) {
		this.l_tmp = l_tmp;
	}

	public String getH_tmp() {
		return h_tmp;
	}

	public void setH_tmp(String h_tmp) {
		this.h_tmp = h_tmp;
	}

	public String getWD() {
		return WD;
	}

	public void setWD(String wD) {
		WD = wD;
	}

	public String getWS() {
		return WS;
	}

	public void setWS(String wS) {
		WS = wS;
	}

	public String getSunrise() {
		return sunrise;
	}

	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}

	public String getSunset() {
		return sunset;
	}

	public void setSunset(String sunset) {
		this.sunset = sunset;
	}
}
