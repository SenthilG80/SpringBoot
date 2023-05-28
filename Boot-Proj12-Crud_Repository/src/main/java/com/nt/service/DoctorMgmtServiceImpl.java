package com.nt.service;


import java.util.List;

//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.doctor;
import com.nt.repository.IDoctorRepo;

@Service("doctorservice")
public class DoctorMgmtServiceImpl implements IDoctorService {
	
	@Autowired
	private IDoctorRepo doctorRepo;
	
	

	 @Override
	public String registerDoctor(doctor doctor1) {
	
		System.out.println("doc id Before ::"+ doctor1.getDocId());
		doctor doc=doctorRepo.save(doctor1);
		return "doc id After ::"+ doc.getDocId();
	 }
//		
//	@Override 
//	public String registerGroupOfDoctors(Iterable<doctor> doctors) {
//		System.out.println(doctorRepo.getClass() +"-------------" +Arrays.toString(doctorRepo.getClass().getMethods()));
//		if(doctors!=null) {
//			Iterable<doctor> savedDoctors=doctorRepo.saveAll(doctors);
//			int size=((Collection<doctor>)savedDoctors).size();
//			List<Integer> ids= (List<Integer>)((Collection<doctor>)savedDoctors).stream().map(d->((doctor)d).getDocId()).collect(Collectors.toList());
//			return size + "no. of doctors are saved with id values :::->"+ 	ids.toString();
//		}	
//		else		
//	        throw new IllegalArgumentException("Invalid Doctors Info");
//		
//	}
//	@Override
//	public long 	fetchDoctorsCount() {
//	
//		 return doctorRepo.count();
//		
//	}
//	@Override
//	public boolean checkDoctorAvailability(Integer id) {
//		return doctorRepo.existsById(id);
//	}
//	@Override
//	public Iterable<doctor> showAllDoctors(){
//		return doctorRepo.findAll();
//	}
//	@Override
//	public  Iterable<doctor> showAllDoctorsByIds(Iterable<Integer> ids){
//		return doctorRepo.findAllById(ids);
//	}
//
//	@Override
//	public String deleteDoctorById(Integer id) {
//		Optional<doctor> opt = doctorRepo.findById(id);
//		if(opt.isPresent()) {
//			doctorRepo.deleteById(id);
//			return id + "doctor is deleted";
//				
//		}else {
//			return id +"doctor not found";
//			
//		}
//	}
//	@Override
//	public String deleteDoctor(doctor dr) {
//		Optional<doctor> opt = doctorRepo.findById(dr.getDocId());
//		if(opt.isEmpty()) {
//			return dr.getDocId() + "doctor is not found";
//		}else {
//			doctorRepo.delete(dr);
//			return dr.getDocId() +"found and deleted";
//		}
//		
//	}
//	@Override
//	public String removeAllDoctors() {
//	 long count=doctorRepo.count();
//	 if  (count>0	) {
//		 doctorRepo.deleteAll();
//		 return count + "no. of records are deleted";
//	 }else {
//		 return "no records found delete";
//	 }
//	}


	@Override
	public String removeDoctorsByIds(List<Integer> ids) {
	   List<doctor> docList=(List<doctor>) doctorRepo.findAllById(ids);
	   if (docList.size()==ids.size()) {
		   doctorRepo.deleteAllById(ids);
		   return docList.size() + "no. of records deleted";
		   
	   }else {
		   return "records are not there to delete";
	   }
	}
}
