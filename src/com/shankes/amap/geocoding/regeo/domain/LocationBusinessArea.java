package com.shankes.amap.geocoding.regeo.domain;

public class LocationBusinessArea {

	// 商圈中心点经纬度
	private String location;
	// 商圈名称
	private String name;// 例如：颐和园
	// 商圈所在区域的adcode
	private String id;// 例如朝阳区/海淀区

	@Override
	public String toString() {
		return "LocationBusinessArea [location=" + location + ", name=" + name + ", id=" + id + "]";
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
