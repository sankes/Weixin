package com.shankes.amap.geocoding.regeo.domain;

public class LocationStreetNumber {

	// 街道名称
	private String street;// 例如：中关村北二条
	// 门牌号
	private String number;// 例如：3号
	// 坐标点
	private String location;// 经纬度坐标点：经度,纬度
	// 方向
	private String direction;// 坐标点所处街道方位
	// 门牌地址到请求坐标的距离
	private String distance;// 单位：米

	@Override
	public String toString() {
		return "LocationStreetNumber [street=" + street + ", number=" + number + ", location=" + location
				+ ", direction=" + direction + ", distance=" + distance + "]";
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}
}
