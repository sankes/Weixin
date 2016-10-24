package com.shankes.amap.geocoding.regeo.domain;

import java.util.List;

public class LocationAddressComponent {

	// 坐标点所在省名称
	private String province;// 例如：北京市
	// 坐标点所在城市名称
	private String city;// 当所在城市为四个直辖市时，该字段返回为空
	// 城市编码
	private String citycode;// 例如：010
	// 坐标点所在区
	private String district;// 例如：海淀区
	// 行政区编码
	private String adcode;// 例如：110108
	// 坐标点所在乡镇/街道（此街道为社区街道，不是道路信息）
	private String township;// 例如：燕园街道
	// 乡镇街道编码
	private String towncode;// 例如：110101001000
	// 社区信息列表
	private LocationNeighborhood neighborhood;
	// 楼信息列表
	private LocationBuilding building;
	// 门牌信息列表
	private LocationStreetNumber streetNumber;
	// 所属海域信息
	private String seaArea;// 例如：渤海
	// 经纬度所属商圈列表
	private List<LocationBusinessArea> businessAreas;

	@Override
	public String toString() {
		return "LocationAddressComponent [province=" + province + ", city=" + city + ", citycode=" + citycode
				+ ", district=" + district + ", adcode=" + adcode + ", township=" + township + ", towncode=" + towncode
				+ ", neighborhood=" + neighborhood + ", building=" + building + ", streetNumber=" + streetNumber
				+ ", seaArea=" + seaArea + ", businessAreas=" + businessAreas + "]";
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAdcode() {
		return adcode;
	}

	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}

	public String getTownship() {
		return township;
	}

	public void setTownship(String township) {
		this.township = township;
	}

	public String getTowncode() {
		return towncode;
	}

	public void setTowncode(String towncode) {
		this.towncode = towncode;
	}

	public LocationNeighborhood getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(LocationNeighborhood neighborhood) {
		this.neighborhood = neighborhood;
	}

	public LocationBuilding getBuilding() {
		return building;
	}

	public void setBuilding(LocationBuilding building) {
		this.building = building;
	}

	public LocationStreetNumber getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(LocationStreetNumber streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getSeaArea() {
		return seaArea;
	}

	public void setSeaArea(String seaArea) {
		this.seaArea = seaArea;
	}

	public List<LocationBusinessArea> getBusinessAreas() {
		return businessAreas;
	}

	public void setBusinessAreas(List<LocationBusinessArea> businessAreas) {
		this.businessAreas = businessAreas;
	}
}
