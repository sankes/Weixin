package com.shankes.amap.weather.domain;

public class WeahterCast {
	private String date;// 日期
	private String week;// 星期几
	private String dayweather;// 白天天气现象
	private String nightweather;// 晚上天气现象
	private int daytemp;// 白天温度
	private int nighttemp;// 晚上温度
	private String daywind;// 白天风向
	private String nightwind;// 晚上风向
	private int daypower;// 白天风力
	private int nightpower;// 晚上风力

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getDayweather() {
		return dayweather;
	}

	public void setDayweather(String dayweather) {
		this.dayweather = dayweather;
	}

	public String getNightweather() {
		return nightweather;
	}

	public void setNightweather(String nightweather) {
		this.nightweather = nightweather;
	}

	public int getDaytemp() {
		return daytemp;
	}

	public void setDaytemp(int daytemp) {
		this.daytemp = daytemp;
	}

	public int getNighttemp() {
		return nighttemp;
	}

	public void setNighttemp(int nighttemp) {
		this.nighttemp = nighttemp;
	}

	public String getDaywind() {
		return daywind;
	}

	public void setDaywind(String daywind) {
		this.daywind = daywind;
	}

	public String getNightwind() {
		return nightwind;
	}

	public void setNightwind(String nightwind) {
		this.nightwind = nightwind;
	}

	public int getDaypower() {
		return daypower;
	}

	public void setDaypower(int daypower) {
		this.daypower = daypower;
	}

	public int getNightpower() {
		return nightpower;
	}

	public void setNightpower(int nightpower) {
		this.nightpower = nightpower;
	}
}
