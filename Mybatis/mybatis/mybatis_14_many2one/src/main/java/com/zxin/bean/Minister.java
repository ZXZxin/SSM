package com.zxin.bean;

public class Minister {
	private Integer mid;
	private String mname;
	// 关联属性
	private Country country;
	
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Minister [mid=" + mid + ", mname=" + mname + ", country="
				+ country + "]";
	}
}
