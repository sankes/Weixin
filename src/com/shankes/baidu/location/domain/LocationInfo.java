package com.shankes.baidu.location.domain;

public class LocationInfo {

	private String status;// 状态码 0代表成功，如果失败则返回其他数字
	private String message;// 状态码描述,"ok"
	private LocationLatLng location;// 经纬度
	private LocationData address_component;// 地址信息
	private String formatted_address;// 地址结构化描述
	private String custom_location_description;// 用户定义位置描述
	private String recommended_location_description;// 推荐的位置描述,结合custom_pois和pois计算推荐结果

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocationLatLng getLocation() {
		return location;
	}

	public void setLocation(LocationLatLng location) {
		this.location = location;
	}

	public LocationData getAddress_component() {
		return address_component;
	}

	public void setAddress_component(LocationData address_component) {
		this.address_component = address_component;
	}

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public String getCustom_location_description() {
		return custom_location_description;
	}

	public void setCustom_location_description(String custom_location_description) {
		this.custom_location_description = custom_location_description;
	}

	public String getRecommended_location_description() {
		return recommended_location_description;
	}

	public void setRecommended_location_description(String recommended_location_description) {
		this.recommended_location_description = recommended_location_description;
	}

}
