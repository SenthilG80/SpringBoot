package com.nt.entity;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;


@Entity
@Table(name= "JPA_DOCTOR_INFO")
@Data
public class doctor {
	
	@Id
	@SequenceGenerator(name="gen1",sequenceName="DOCID_SEQ",initialValue=100, allocationSize=1)
	@GeneratedValue(generator="gen1", strategy=GenerationType.SEQUENCE)
	 // @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DOC_ID")
	private Integer docId;
	
	@Column(name="DOC_NAME", length=25)
	private String docName;
	
	//@Transient
	@Column(name="SPECIALIZATION", length=20)
	 private String Specialization;
	
	@Column(name="INCOME")
	private Double income;

	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getSpecialization() {
		return Specialization;
	}

	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	@Override
	public String toString() {
		return "doctor [docId=" + docId + ", docName=" + docName + ", Specialization=" + Specialization + ", income="
				+ income + "]";
	}
	

}
