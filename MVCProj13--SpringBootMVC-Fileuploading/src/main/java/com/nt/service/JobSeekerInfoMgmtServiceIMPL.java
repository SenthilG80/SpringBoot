package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.JobSeekerInfo;
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

}
