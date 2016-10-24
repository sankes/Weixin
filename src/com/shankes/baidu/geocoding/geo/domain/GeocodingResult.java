package com.shankes.baidu.geocoding.geo.domain;

public class GeocodingResult {

	private GeocodingLocation location;// 经纬度坐标
	private int precise;// 位置的附加信息，是否精确查找。1为精确查找，即准确打点；0为不精确，即模糊打点。
	private int confidence;// 可信度，描述打点准确度
	private String level;// 地址类型

	@Override
	public String toString() {
		return "GeocodingResult [location=" + location.toString()
				+ ", precise=" + precise + ", confidence=" + confidence
				+ ", level=" + level + "]";
	}

	public GeocodingLocation getLocation() {
		return location;
	}

	public void setLocation(GeocodingLocation location) {
		this.location = location;
	}

	public int getPrecise() {
		return precise;
	}

	public void setPrecise(int precise) {
		this.precise = precise;
	}

	public int getConfidence() {
		return confidence;
	}

	public void setConfidence(int confidence) {
		this.confidence = confidence;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
}
