package com.shankes.baidu.city.domain;

public class CityData {

	private String cityName;// 市
	private String provinceName;// 省
	private String cityCode;// 天气预报城市代码
	private String zipCode; // 邮编
	private String telAreaCode;// 电话区号

	@Override
	public String toString() {
		return "CityData [cityName=" + cityName + ", provinceName=" + provinceName + ", cityCode=" + cityCode
				+ ", zipCode=" + zipCode + ", telAreaCode=" + telAreaCode + "]";
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getTelAreaCode() {
		return telAreaCode;
	}

	public void setTelAreaCode(String telAreaCode) {
		this.telAreaCode = telAreaCode;
	}

}
