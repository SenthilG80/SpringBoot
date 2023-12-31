package com.nt.service;

import java.util.List;

import com.nt.entity.JobSeekerInfo;


public interface IJobSeekerInfoMgmtService {
  public String registerJobSeeker(JobSeekerInfo jsinfo); 
  public List<JobSeekerInfo> getAllJobSeekersInfo();
  public String findResumePathById(Integer Id);
  public String findPhotoPathById(Integer Id);
}
