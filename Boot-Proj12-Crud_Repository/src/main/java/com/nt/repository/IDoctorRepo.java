package com.nt.repository;

import org.springframework.data.repository.CrudRepository;

import com.nt.entity.doctor;

public interface IDoctorRepo extends CrudRepository<doctor, Integer> {

}
