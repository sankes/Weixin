package com.shankes.amap.weather.domain;

import java.util.List;

public class WeatherForecast {
	private String city;// 城市名称
	private long adcode;// 城市编码
	private String province;// 省份名称
	private String reporttime;// 预报发布时间
	private List<WeahterCast> casts;// 预报数据list结构，元素cast,按顺序为当天、第二天、第三天的预报数据

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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getReporttime() {
		return reporttime;
	}

	public void setReporttime(String reporttime) {
		this.reporttime = reporttime;
	}

	public List<WeahterCast> getCasts() {
		return casts;
	}

	public void setCasts(List<WeahterCast> casts) {
		this.casts = casts;
	}
}
