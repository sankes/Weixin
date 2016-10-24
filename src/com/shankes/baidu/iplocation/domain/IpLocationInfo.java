package com.shankes.baidu.iplocation.domain;

public class IpLocationInfo {

	private String address;// "CN|北京|北京|None|CHINANET|1|None", 地址
	private IpLocationContent content;// 详细内容
	private String status;// 0 返回状态码

	@Override
	public String toString() {
		return "IpLocationInfo [address=" + address + ", content=" + content + ", status=" + status + "]";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public IpLocationContent getContent() {
		return content;
	}

	public void setContent(IpLocationContent content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
