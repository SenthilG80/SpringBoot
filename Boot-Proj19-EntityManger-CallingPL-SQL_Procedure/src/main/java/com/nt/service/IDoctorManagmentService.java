package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor;

public interface IDoctorManagmentService {
	public List<Doctor> showDoctorsByIncomeRange(double start,double end);
}
