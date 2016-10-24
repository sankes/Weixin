package com.shankes.amap.geocoding.regeo.domain;

public class LocationRoadinter {

	// 交叉路口到请求坐标的距离
	private String distance;// 单位：米
	// 方位
	private String direction;
	// 路口经纬度
	private String location;
	// 第一条道路id
	private String first_id;
	// 第一条道路名称
	private String first_name;
	// 第二条道路id
	private String second_id;
	// 第二条道路名称
	private String second_name;

	@Override
	public String toString() {
		return "LocationRoadinter [distance=" + distance + ", direction=" + direction + ", location=" + location
				+ ", first_id=" + first_id + ", first_name=" + first_name + ", second_id=" + second_id
				+ ", second_name=" + second_name + "]";
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFirst_id() {
		return first_id;
	}

	public void setFirst_id(String first_id) {
		this.first_id = first_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getSecond_id() {
		return second_id;
	}

	public void setSecond_id(String second_id) {
		this.second_id = second_id;
	}

	public String getSecond_name() {
		return second_name;
	}

	public void setSecond_name(String second_name) {
		this.second_name = second_name;
	}
}
