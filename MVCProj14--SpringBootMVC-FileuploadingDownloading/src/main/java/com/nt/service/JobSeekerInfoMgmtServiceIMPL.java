package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.JobSeekerInfo;
import com.nt.model.JobSeeker;
import com.nt.repository.IJobSeekerInfoRepository;

@Service("jsService")
public class JobSeekerInfoMgmtServiceIMPL implements IJobSeekerInfoMgmtService {
    @Autowired
	private IJobSeekerInfoRepository jsRepo;
	@Override
	public String registerJobSeeker(JobSeekerInfo jsInfo) {
		int idval=jsRepo.save(jsInfo).getJsId();
		return "Job seeker is registered with id value ::" + idval;
	}
	@Override
	public List<JobSeekerInfo> getAllJobSeekersInfo() {
	
		return jsRepo.findAll();
	}
	@Override
	public String findResumePathById(Integer Id) {
		// TODO Auto-generated method stub
		return jsRepo.getResumePathById(Id);
	}
	@Override
	public String findPhotoPathById(Integer Id) {
		// TODO Auto-generated method stub
		return jsRepo.getPhotoPathById(Id);
	}

}
