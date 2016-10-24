package com.shankes.amap.geocoding.regeo.domain;

public class LocationAoi {

	// 所属兴趣点ID
	private String id;
	// 所属兴趣点名称
	private String name;
	// 所属兴趣点所在区域编码
	private String adcode;
	// 所属兴趣点中心点坐标
	private String location;
	// 所属兴趣点面积
	private String area;// 单位：平方米

	@Override
	public String toString() {
		return "LocationAoi [id=" + id + ", name=" + name + ", adcode=" + adcode + ", location=" + location + ", area="
				+ area + "]";
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

	public String getAdcode() {
		return adcode;
	}

	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
}
