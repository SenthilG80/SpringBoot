package com.nt.Entitys;






import java.io.Serializable;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="BOOT_EMP1")
@Data
@SQLDelete(sql="UPDATE BOOT_EMP1 SET STATUS ='DELETED'  WHERE EMP_NO=?")
@Where(clause="STATUS <> 'DELETED' ")
public class EmployeeInfo implements Serializable{
	@Id
	@SequenceGenerator(name="gen1",sequenceName ="emp_id_seq",allocationSize = 1,initialValue = 251 )
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer empNo;
	
	@Column(length = 20)
	private String ename;
	private Double sal;
	@Column(length = 20)
	private String job="CLERK";
	private String status="ACTIVE";
	
	
}
