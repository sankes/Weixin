package com.shankes.baidu.iplocation.domain;

public class IpLocationPoint {

	private String x;// "116.39564504"
	private String y;// "39.92998578"

	@Override
	public String toString() {
		return "IpLocationPoint [x=" + x + ", y=" + y + "]";
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}
}
