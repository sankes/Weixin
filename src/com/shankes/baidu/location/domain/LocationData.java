package com.shankes.baidu.location.domain;

public class LocationData {

	private String country;// 国家
	private String province;// 省
	private String city;// 市
	private String district;// 区、县
	private String street;// 街道
	private String street_number;// 街道门牌号
	private String admin_area_code;// 行政区划代码,110108
	private String country_code;// 国家代码,0

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet_number() {
		return street_number;
	}

	public void setStreet_number(String street_number) {
		this.street_number = street_number;
	}

	public String getAdmin_area_code() {
		return admin_area_code;
	}

	public void setAdmin_area_code(String admin_area_code) {
		this.admin_area_code = admin_area_code;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
}
