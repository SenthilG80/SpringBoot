package com.nt.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("cust")
@ConfigurationProperties(prefix="cust.info")
public class CustomerInfo {
	private Integer cno;
	private String cname;
	private String caddr;
	private Double billAmt;
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public void setCaddr(String caddr) {
		this.caddr = caddr;
	}
	public void setBillAmt(Double billAmt) {
		this.billAmt = billAmt;
	}
	@Override
	public String toString() {
		return "CustomerInfo [cno=" + cno + ", cname=" + cname + ", caddr=" + caddr + ", billAmt=" + billAmt + "]";
	}

}
