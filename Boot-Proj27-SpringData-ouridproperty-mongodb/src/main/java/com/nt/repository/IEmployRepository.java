package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.Employee;

public interface IEmployRepository extends MongoRepository<Employee, Integer> {

}
