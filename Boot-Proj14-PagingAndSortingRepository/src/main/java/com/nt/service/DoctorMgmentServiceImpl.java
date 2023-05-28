package com.nt.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;

@Service
public class DoctorMgmentServiceImpl implements IDoctorMgmtService {
	@Autowired
	private IDoctorRepository doctorRepo;
 
	@Override
	public Iterable<Doctor> showDoctorsBySorting(boolean asc, String... props) {
     Sort sort=Sort.by(asc?Direction.ASC:Direction.DESC,props);
     Iterable<Doctor> it = doctorRepo.findAll(sort);
     
		System.out.println("Class name of Doctor Repo" + doctorRepo.getClass());
		return it;
	}

	@Override
	public Page<Doctor> showDoctorsInfo(int pageNo, int pageSize, boolean ascOrder, String props) {
		 Sort sort=Sort.by(ascOrder?Direction.ASC:Direction.DESC,props);
		 Pageable pageable=PageRequest.of(pageNo, pageSize,sort);
		 Page<Doctor> page=doctorRepo.findAll(pageable);
		 
		return page;
	}

	@Override
	public void showDataThroughPagination(int pageSize) {
	 long count =doctorRepo.count();
	 System.out.println("Number of Records ::" +count);
	 long pagesCount=count/pageSize;
	 pagesCount=count%pageSize==0?pagesCount: ++pagesCount;
	 for(int i=0;i<pagesCount;i++) {
		 Pageable pageable=PageRequest.of(i, pageSize);
		 Page<Doctor> page=doctorRepo.findAll(pageable);
		 System.out.println("Page ::"+ (page.getNumber()+1)+"records of "+page.getTotalPages());
		 page.getContent().forEach(System.out::println);
		 System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
		 
		 
	 }
		
	}

}
