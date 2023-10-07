package com.nt.service;

import java.util.List;

import com.nt.Entitys.EmployeeInfo;

public interface IEmployeeMgmtService {
  public List<EmployeeInfo> getAllEmpsData();
  public String addEmployee(EmployeeInfo emp);
  public EmployeeInfo findEmployeeByEno(int eno);
  public String updateEmployee(EmployeeInfo emp);
  public String deleteEmployee(int no);
  
  
}
