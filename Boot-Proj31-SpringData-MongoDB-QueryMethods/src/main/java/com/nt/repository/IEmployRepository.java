package com.nt.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nt.document.Employee;

public interface IEmployRepository extends MongoRepository<Employee, String> {
   
	@Query(value="{eadd:?0}", fields="{id:0,eno:1,ename:1}")
	public List<Object[]> getEmpsDataByAddrs(String addr);
	
	@Query(value="{eadd:?0}", fields="{}")
	public List<Employee> getEmpsFullDataByAddrs(String addr);
   
	@Query(value="{eadd:?1,salary:?0}", fields="{id:0,ename:1,eadd:1,salary:1}")
	public List<Object[]> getEmpsDataBySalaryAndAddrs(double salary,String addrs);
	
	@Query(value="{salary:{$gte:?0}, salary:{$lte:?1}}", fields="{id:0,ename:1,eadd:1,salary:1}")
	public List<Object[]> getEmpsDataBySalaryRange(double start,double end);
	
	@Query(value= "{$or:[{eadd:?0},{eadd:?1}]}")
	public List<Employee> getFullEmployeeByAddress(String addrs1, String addrs2);
	
	@Query(value="{ename:{'$regex':?0,'$options':'i'}}")
     public List<Employee> getEmployeeDataByEnameInitialChars(String initiChars);

	@Query(value="{salary:{$gte:?0, $lte:?1}}",count=true)
	 public int getEmployeeCountBySalaryRange(double start, double end);
	
	@Query(value="{}",sort="{ename:-1}")
	public List<Employee> getEmployeesByEnameSorting();

	@Query(value="{eno:null}",delete=true)
	public int removeEmptyEnoEmployees();
	
	
	@Query(value="{salary:{$gte:?0, $lte:?1}}",exists=true)
	public boolean existsEmployeeBySalaryRange(double start,double end);
	
}
