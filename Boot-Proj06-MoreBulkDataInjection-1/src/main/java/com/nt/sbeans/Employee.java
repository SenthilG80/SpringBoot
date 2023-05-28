package com.nt.sbeans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("emp")
@Data  
@ConfigurationProperties(prefix="emp.info")
public class Employee {
	private Integer empNo;
	 private String 	 empName;
	 private  String empAddrs;
	

	private String[]  favColors;
	 private List<String> nickNames;
	 private Set<Long> phoneNumbers;	
	 private 	Map<String,Long> idDetails;
	 
	 private Company company;
	 public void setFavColors(String[] favColors) {
			this.favColors = favColors;
		}
	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddrs() {
		return empAddrs;
	}

	public void setEmpAddrs(String empAddrs) {
		this.empAddrs = empAddrs;
	}

	public List<String> getNickNames() {
		return nickNames;
	}

	public void setNickNames(List<String> nickNames) {
		this.nickNames = nickNames;
	}

	public Set<Long> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<Long> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Map<String, Long> getIdDetails() {
		return idDetails;
	}

	public void setIdDetails(Map<String, Long> idDetails) {
		this.idDetails = idDetails;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", empAddrs=" + empAddrs + ", nickNames="
				+ nickNames + ", phoneNumbers=" + phoneNumbers + ", idDetails=" + idDetails + ", company=" + company
				+ "]";
	}
	
	 
}
