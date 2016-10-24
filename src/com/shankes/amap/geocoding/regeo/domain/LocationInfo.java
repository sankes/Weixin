package com.shankes.amap.geocoding.regeo.domain;

public class LocationInfo {

	// 返回结果状态值
	private String status;// 值为0或1,0表示false；1表示true
	// 返回状态说明
	private String info;// status为0时，info返回错误原因，否则返回“OK”。详情参阅info状态表
	// "10000"
	private String infocode;
	// 逆地理编码列表
	private LocationRegeocode regeocode;// batch=true返回此标签，标签下为regeocode对象列表；batch=false直接返回regeocode对象；regeocode对象包含的数据如下

	@Override
	public String toString() {
		return "LocationInfo [status=" + status + ", info=" + info + ", infocode=" + infocode + ", regeocodes="
				+ regeocode + "]";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getInfocode() {
		return infocode;
	}

	public void setInfocode(String infocode) {
		this.infocode = infocode;
	}

	public LocationRegeocode getRegeocodes() {
		return regeocode;
	}

	public void setRegeocodes(LocationRegeocode regeocodes) {
		this.regeocode = regeocodes;
	}
}
