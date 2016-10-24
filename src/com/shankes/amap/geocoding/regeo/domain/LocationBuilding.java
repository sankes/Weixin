package com.shankes.amap.geocoding.regeo.domain;

public class LocationBuilding {

	// 建筑名称
	private String name;// 例如：北京大学<
	// 类型
	private String type;// 例如：科教文化服务;学校;高等院校

	@Override
	public String toString() {
		return "LocationBuilding [name=" + name + ", type=" + type + "]";
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
}
