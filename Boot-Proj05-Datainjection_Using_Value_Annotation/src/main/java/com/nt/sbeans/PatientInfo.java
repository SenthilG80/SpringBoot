package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("pinfo")
@Data
public class PatientInfo {
	@Value("10001")
	private Integer pid;
	
	@Value("${pi.name}")
	private String pname;
	
	@Value("${pi.mobilenumber}")
	private  Long mobileNo;
	
	@Value("${pi.address}")
	private String paddress;
	
	@Value("#{dcc.xrayPrice + dcc.ctscanPrice + dcc.mriscanPrice}") //SPEL based injection 	 	
	private Double billAmount;
	
	@Value("${os.name}")
	private String  	 osName; //To System property  - hold environment variable values

	@Value("${Path}")
	private String pathData; // To Hold env variable


	public Integer getPid() {
		return pid;
	}


	public void setPid(Integer pid) {
		this.pid = pid;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public Long getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getPaddress() {
		return paddress;
	}


	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}


	public Double getBillAmount() {
		return billAmount;
	}


	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}


	public String getOsName() {
		return osName;
	}


	public void setOsName(String osName) {
		this.osName = osName;
	}


	public String getPathData() {
		return pathData;
	}


	public void setPathData(String pathData) {
		this.pathData = pathData;
	}


	@Override
	public String toString() {
		return "PatientInfo [pid=" + pid + ", pname=" + pname + ", mobileNo=" + mobileNo + ", paddress=" + paddress
				+ ", billAmount=" + billAmount + ", osName=" + osName + ", pathData=" + pathData + "]";
	}
	
	

}
