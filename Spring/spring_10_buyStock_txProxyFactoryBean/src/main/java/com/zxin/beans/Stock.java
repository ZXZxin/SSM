package com.zxin.beans;

public class Stock {
	private Integer sid;
	private String sname;   // 股票名称
	private int count;      // 股票数量
	public Stock() {
		super();
	}
	public Stock(String sname, int count) {
		super();
		this.sname = sname;
		this.count = count;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Stock [sid=" + sid + ", sname=" + sname + ", count=" + count
				+ "]";
	}
}
