package com.nt.repository;

import org.springframework.data.repository.CrudRepository;

import com.nt.Entitys.EmployeeInfo;

public interface IEmployeeInfoRepository extends CrudRepository<EmployeeInfo, Integer>{

}
