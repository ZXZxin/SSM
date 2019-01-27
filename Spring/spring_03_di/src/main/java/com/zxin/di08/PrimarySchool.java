package com.zxin.di08;

public class PrimarySchool extends School {
	private String address;

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "PrimarySchool [address=" + address + "]";
	}
}
