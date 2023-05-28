package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Doctor;


public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
 public Iterable<Doctor> findByDocNameEquals(String ame);
 public Iterable<Doctor> findByDocNameIs(String ame);
 public Iterable<Doctor> findByDocName(String ame);
 public Iterable<Doctor> findByIncomeBetween(Double start, Double end);
 //public List<Doctor> findBySpecializationIn(List<String> aenk);
 public Iterable<Doctor> findByDocNameLike(String ame);
 public Iterable <Doctor> findByIncomeLessThanEqualAndIncomeGreaterThanEqual(double startRange,double endRange);
 public Iterable<Doctor> findByspecializationInOrIncomeBetween(List<String> specials,double start, double end);
 
}
