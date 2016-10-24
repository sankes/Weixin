package com.shankes.amap.geocoding.regeo.domain;

import java.util.List;

public class LocationRegeocode {

	// 结构化地址信息
	private String formatted_address;// 结构化地址信息包括：省+市+区+乡镇+街道+门牌号如果坐标点处于海域范围内，则结构化地址信息为：省+市+区+海域信息
	// 地址元素列表
	private LocationAddressComponent addressComponent;
	// 道路信息列表
	private List<LocationRoad> roads;// 请求参数extensions=all时返回；extensions=base时不返回
	// 道路交叉口列表
	private List<LocationRoadinter> roadinters;// 请求参数extensions=all时返回；extensions=base时不返回
	// poi信息列表
	private List<LocationPoi> pois;// 请求参数extensions=all时返回；extensions=base时不返回
	// aoi信息列表
	private List<LocationAoi> aois;// 请求参数extensions=all时返回；extensions=base时不返回

	@Override
	public String toString() {
		return "LocationRegeocodes [formatted_address=" + formatted_address + ", addressComponent=" + addressComponent
				+ ", roads=" + roads + ", roadinters=" + roadinters + ", pois=" + pois + ", aois=" + aois + "]";
	}

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public LocationAddressComponent getAddressComponent() {
		return addressComponent;
	}

	public void setAddressComponent(LocationAddressComponent addressComponent) {
		this.addressComponent = addressComponent;
	}

	public List<LocationRoad> getRoads() {
		return roads;
	}

	public void setRoads(List<LocationRoad> roads) {
		this.roads = roads;
	}

	public List<LocationRoadinter> getRoadinters() {
		return roadinters;
	}

	public void setRoadinters(List<LocationRoadinter> roadinters) {
		this.roadinters = roadinters;
	}

	public List<LocationPoi> getPois() {
		return pois;
	}

	public void setPois(List<LocationPoi> pois) {
		this.pois = pois;
	}

	public List<LocationAoi> getAois() {
		return aois;
	}

	public void setAois(List<LocationAoi> aois) {
		this.aois = aois;
	}
}
