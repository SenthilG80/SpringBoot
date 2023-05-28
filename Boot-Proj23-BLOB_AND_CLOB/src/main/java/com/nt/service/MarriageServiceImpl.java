package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.MarriageSeeker;
import com.nt.repository.IMarriageSeekerRepository;

@Service("marriageService")
public class MarriageServiceImpl implements IMarriageSeekerServiceMgmt {
     @Autowired
	 private IMarriageSeekerRepository msRepo;
	 
	@Override
	public String registerMarriageSeeker(MarriageSeeker seeker) {
		int idVal=msRepo.save(seeker).getMsid();
		return "Marriage Seeker is registered with the id value::"+idVal;
		
	}

	@Override
	public MarriageSeeker searchSeekerById(Integer id) {
		// TODO Auto-generated method stub
		return msRepo.findById(id).orElseThrow(()->new IllegalArgumentException());
		
	}

}
