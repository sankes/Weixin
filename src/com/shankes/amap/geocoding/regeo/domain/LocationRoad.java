package com.shankes.amap.geocoding.regeo.domain;

public class LocationRoad {

	// 道路id
	private String id;
	// 道路名称
	private String name;
	// 道路到请求坐标的距离
	private String distance;// 单位：米
	// 方位
	private String direction;
	// 坐标点
	private String location;

	@Override
	public String toString() {
		return "LocationRoad [id=" + id + ", name=" + name + ", distance=" + distance + ", direction=" + direction
				+ ", location=" + location + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
}
