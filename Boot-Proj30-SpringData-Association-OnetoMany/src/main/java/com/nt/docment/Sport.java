package com.nt.docment;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Setter
@Getter
public class Sport {
	@Id
	private Long sid;
	private  String type;
	private String[] kititems;
	@Override
	public String toString() {
		return "Sport [sid=" + sid + ", type=" + type + ", kititems=" + Arrays.toString(kititems) + "]";
	}
	

}
