package com.shankes.baidu.geocoding.geo.domain;

public class GeocodingLocation {

	private float lat;// 纬度值
	private float lng;// 经度值

	@Override
	public String toString() {
		return "GeocodingLocation [lat=" + lat + ", lng=" + lng + "]";
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLng() {
		return lng;
	}

	public void setLng(float lng) {
		this.lng = lng;
	}
}
