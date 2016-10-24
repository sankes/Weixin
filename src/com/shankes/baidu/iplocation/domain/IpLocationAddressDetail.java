package com.shankes.baidu.iplocation.domain;

public class IpLocationAddressDetail {

	private String city;// "北京市",城市
	private String city_code;// 131,百度城市代码
	private String district;// 区县
	private String province;// "北京市",省份
	private String street;// 街道
	private String street_number;// 门址

	@Override
	public String toString() {
		return "IpLocationAddressDetail [city=" + city + ", city_code=" + city_code + ", district=" + district
				+ ", province=" + province + ", street=" + street + ", street_number=" + street_number + "]";
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity_code() {
		return city_code;
	}

	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
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
}
