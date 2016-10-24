package com.shankes.amap.geocoding.regeo.domain;

public class LocationPoi {

	// 兴趣点id
	private String id;
	// 兴趣点名称
	private String name;
	// 兴趣点类型
	private String type;
	// 电话
	private String tel;
	// 该POI到请求坐标的距离
	private String distance;// 单位：米
	// 方向
	private String direction;
	// poi地址信息
	private String address;
	// 坐标点
	private String location;
	// poi所在商圈名称
	private String businessarea;

	@Override
	public String toString() {
		return "LocationPoi [id=" + id + ", name=" + name + ", type=" + type + ", tel=" + tel + ", distance="
				+ distance + ", direction=" + direction + ", address=" + address + ", location=" + location
				+ ", businessarea=" + businessarea + "]";
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBusinessarea() {
		return businessarea;
	}

	public void setBusinessarea(String businessarea) {
		this.businessarea = businessarea;
	}
}
