package com.nt.sbeans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Setter;

@Setter
public class Company {
	private String name;
	private Integer Size;
	private String addrs;
	private Long pinCode;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSize() {
		return Size;
	}
	public void setSize(Integer size) {
		Size = size;
	}
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public Long getPinCode() {
		return pinCode;
	}
	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}
	@Override
	public String toString() {
		return "ccompany [name=" + name + ", Size=" + Size + ", addrs=" + addrs + ", pinCode=" + pinCode + "]";
	}
	
	
	
	
}
