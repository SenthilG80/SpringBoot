package com.nt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Doctor;


public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
	
	//@Query("FROM Doctor WHERE income BETWEEN  ?1 AND ?2")
	//@Query("FROM com.nt.entity.Doctor WHERE income BETWEEN  ?1 AND ?2")
	//@Query("FROM Doctor doc WHERE doc.income BETWEEN  ?1 AND ?2")
//	@Query("FROM Doctor WHERE income BETWEEN  :start AND :end")
//     public List<Doctor> searchDoctorsByIncomeBetween(@Param("start") Float startRange, @Param("end")Float endRange);
  
	
	//Select ---- Entity Query
	 @Query("FROM Doctor WHERE specialization IN(:sp1, :sp2) ORDER BY specialization")
	 public List<Doctor> searchDoctorsBySpecialization(@Param("sp1") String sp1, @Param("sp2") String sp2);
	 
	 
	 //select -- Projection Query with specific multiple 
	 @Query("SELECT docId, docName, income FROM Doctor WHERE income BETWEEN :start and :end")
	 public List<Object[]> searchDoctorsByIncome(double start, double end);
	 
	 
	 //select - Projeciton Query with Single Column 
	 
	 @Query("SELECT docName FROM Doctor WHERE income BETWEEN :min and :max")
	 public List<String> showDoctorInfoByName(double min, double max);


//Select ---- Single row through Entity Query
		 @Query("FROM Doctor WHERE docName=:name")
		 public Optional<Doctor> showDoctorInfoByName(String name);
		 
		//Select ---- Single row through Entity Query - Multiple Columns
		 @Query("SELECT docId, docName FROM Doctor WHERE docName=:name")
		 public Object showDoctorDataByName(String name);
		 
		 
			//Select ---- Single row through Entity Query - Single Columns
		 @Query("SELECT specialization FROM Doctor WHERE docName=:name")
		 public String showSpecializationByName(String name);

		 
			//Select ---- aggregrate operations
		 @Query("SELECT  count(distinct docName) FROM Doctor")
		 public int fetchDoctorsNameCount();
		 
          @Query("SELECT count(*),max(income),min(income),avg(income),sum(income) from Doctor")
          	public Object fetchAggregateData();
          
         //---------------------Non - Select Operations using HQL/JPQL-----------------------------
          @Query("UPDATE  Doctor SET income=income + (income * :percentage/100.0) WHERE specialization=:sp")
          @Modifying
           @Transactional
          public int hikeDoctosIncomeBySpecialization(String sp, double percentage);
          

          @Query("DELETE FROM Doctor WHERE income>:start and income<:end")
          @Modifying
           @Transactional
          public int removeDocotrsByIncomeRange(double start,double end);
          
          //Native SQL Query
          @Query(value = "INSERT INTO JPA_DOCTOR_INFO VALUES(DOCID_SEQ.NEXTVAL,:special,:name,:income)", nativeQuery =true)
          @Modifying
          @Transactional
          public int registerDoctor(String special, String name,  double income);
          
          
          @Query(value = "SELECT SYSDATE FROM DUAL", nativeQuery =true)
          public String showSystemDate();
          
      	@Query(value="CREATE TABLE TEMP (col1 number(5))",nativeQuery =true)
        @Modifying
        @Transactional	
        public int createTempTable();
}
