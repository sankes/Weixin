package com.shankes.baidu.iplocation.domain;

public class IpLocationContent {

	private String address;// "北京市", 简要地址
	private IpLocationAddressDetail address_detail;// 详细地址信息
	private IpLocationPoint point;// 百度经纬度坐标值

	@Override
	public String toString() {
		return "IpLocationContent [address=" + address + ", address_detail=" + address_detail + ", point=" + point
				+ "]";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public IpLocationAddressDetail getAddress_detail() {
		return address_detail;
	}

	public void setAddress_detail(IpLocationAddressDetail address_detail) {
		this.address_detail = address_detail;
	}

	public IpLocationPoint getPoint() {
		return point;
	}

	public void setPoint(IpLocationPoint point) {
		this.point = point;
	}
}
