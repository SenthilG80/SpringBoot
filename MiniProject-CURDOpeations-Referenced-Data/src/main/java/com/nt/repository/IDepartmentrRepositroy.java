package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.Entitys.Department;

public interface IDepartmentrRepositroy extends JpaRepository<Department, Integer>{
	
	@Query("SELECT deptno from Department")
	public List<Integer> getAllDeptnos();

}
