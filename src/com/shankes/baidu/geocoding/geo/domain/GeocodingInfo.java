package com.shankes.baidu.geocoding.geo.domain;

public class GeocodingInfo {

	private int status;// 返回结果状态值， 成功返回0，其他值请查看下方返回码状态表。
	private GeocodingResult result;// 返回的结果

	@Override
	public String toString() {
		return "GeocodingInfo [status=" + status + ", result="
				+ result.toString() + "]";
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public GeocodingResult getResult() {
		return result;
	}

	public void setResult(GeocodingResult result) {
		this.result = result;
	}

}
