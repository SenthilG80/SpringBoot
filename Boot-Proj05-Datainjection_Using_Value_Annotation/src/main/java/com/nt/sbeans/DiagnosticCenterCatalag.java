package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("dcc")
//@Data
public class DiagnosticCenterCatalag {
@Value("${dc.xrayRate}")
private double xrayPrice;
@Value("${dc.ctscanRate}")
private double ctscanPrice;
@Value("${dc.mriscanRate}")
private double mriscanPrice;
@Value("${dc.ecgRate}")
private double ecgPrice;

public double getXrayPrice() {
	return xrayPrice;
}
public void setXrayPrice(double xrayPrice) {
	this.xrayPrice = xrayPrice;
}
public double getCtscanPrice() {
	return ctscanPrice;
}
public void setCtscanPrice(double ctscanPrice) {
	this.ctscanPrice = ctscanPrice;
}
public double getMriscanPrice() {
	return mriscanPrice;
}
public void setMriscanPrice(double mriscanPrice) {
	this.mriscanPrice = mriscanPrice;
}
public double getEcgPrice() {
	return ecgPrice;
}
public void setEcgPrice(double ecgPrice) {
	this.ecgPrice = ecgPrice;
}

	

}
