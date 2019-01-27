package com.zxin.di06;

import java.util.*;

public class MyCollection {
	private School[] schools;
	private String[] myStrs;
	private List<String> myList;
	private Set<String> mySet;
	private Map<String, Object> myMap;
	private Properties myPros;
	public void setSchools(School[] schools) {
		this.schools = schools;
	}
	public void setMyStrs(String[] myStrs) {
		this.myStrs = myStrs;
	}
	public void setMyList(List<String> myList) {
		this.myList = myList;
	}
	public void setMySet(Set<String> mySet) {
		this.mySet = mySet;
	}
	public void setMyMap(Map<String, Object> myMap) {
		this.myMap = myMap;
	}
	public void setMyPros(Properties myPros) {
		this.myPros = myPros;
	}
	@Override
	public String toString() {
		return "MyCollection [schools=" + Arrays.toString(schools) + ", myStrs="
				+ Arrays.toString(myStrs) + ", myList=" + myList + ", mySet="
				+ mySet + ", myMap=" + myMap + ", myPros=" + myPros + "]";
	}
}
