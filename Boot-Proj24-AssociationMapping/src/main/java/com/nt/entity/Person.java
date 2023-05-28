package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="JPA_OTM_PERSON")
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
    private Integer pid;
	
	@Column(length=20)
	@NonNull
    private String pname;
	
	@Column(length=20)
	@NonNull
    private String paddrs;
	
   
	@OneToMany(targetEntity = PhoneNumber.class,cascade= CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "personInfo")
   // @JoinColumn(name="PERSON_ID",referencedColumnName = "PID")
	private Set<PhoneNumber> contactDetails;


	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}
  
}
