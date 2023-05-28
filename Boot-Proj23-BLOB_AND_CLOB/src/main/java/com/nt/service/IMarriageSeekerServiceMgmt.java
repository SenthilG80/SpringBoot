package com.nt.service;

import java.util.Optional;

import com.nt.entity.MarriageSeeker;

public interface IMarriageSeekerServiceMgmt {
  public String registerMarriageSeeker(MarriageSeeker seeker);
  public MarriageSeeker searchSeekerById(Integer id);
  
}
