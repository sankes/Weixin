package com.shankes.baidu.city.domain;

public class CityInfo {
	private String errNum;
	private String errMsg;
	private CityData retData;

	@Override
	public String toString() {
		return "CityInfo [errNum=" + errNum + ", errMsg=" + errMsg + ", retData=" + retData.toString() + "]";
	}

	public String getErrNum() {
		return errNum;
	}

	public void setErrNum(String errNum) {
		this.errNum = errNum;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public CityData getRetData() {
		return retData;
	}

	public void setRetData(CityData retData) {
		this.retData = retData;
	}

}
