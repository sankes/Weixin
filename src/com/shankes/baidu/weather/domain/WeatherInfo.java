package com.shankes.baidu.weather.domain;


public class WeatherInfo {
	private String errNum;
	private String errMsg;
	private WeatherData retData;

	@Override
	public String toString() {
		return "WeatherInfo [errNum=" + errNum + ", errMsg=" + errMsg + ", retData=" + retData.toString() + "]";
	}
	
	public String toStringFormat(){
		return retData.toStringFormat();
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

	public WeatherData getRetData() {
		return retData;
	}

	public void setRetData(WeatherData retData) {
		this.retData = retData;
	}

}
