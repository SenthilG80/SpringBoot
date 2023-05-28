package com.nt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.entity.Employee_Date_Time;

public interface EmployeeDateTimeRepository extends JpaRepository<Employee_Date_Time, Integer> {
     @Query(nativeQuery=true, value="SELECT YEAR(CURRENT_TIMESTAMP)-YEAR(DOB) FROM EMPLOYEE_DATE_TIME WHERE DESG=:job")
	 public List<Integer> getEmployeeAgesByDesg(@Param("job") String job);
     Optional<Employee_Date_Time> findByename(String name);
     
}
