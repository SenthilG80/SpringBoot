package com.nt.docment;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class PlayerInfo {
	
	@Id
	private Integer id;
	private String pname;
	private String[] nickNames;
	private List<String> friends;
	private Set<Long> phoneNumbers;
	private Map<String, Long> idDetails;
	private Properties kitInfo;
	
	

}
