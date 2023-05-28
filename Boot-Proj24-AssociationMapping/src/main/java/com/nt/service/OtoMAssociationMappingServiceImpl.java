package com.nt.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.repository.IPersonRepository;
import com.nt.repository.IPhoneNumberRepository;

@Service("OtoMService")
public class OtoMAssociationMappingServiceImpl implements IOtoMManagementService {
    @Autowired
	private IPersonRepository personRepo;
    @Autowired
    private IPhoneNumberRepository phoneRepo;
	@Override
	public void saveDataUsingParent() {
		Person per=new Person("Sairam baba","World");
		PhoneNumber ph1=new PhoneNumber(11111111L,"Vodafone","All");
		PhoneNumber ph2=new PhoneNumber(22222222L,"Vodafone","Personal");
		
		//add parent to child
		Set<PhoneNumber> phonesSet=new HashSet<PhoneNumber>();
		phonesSet.add(ph1);
		phonesSet.add(ph2);
		per.setContactDetails(phonesSet);
		personRepo.save(per);
		System.out.println("Person and his associated phoneNumbers are saved(Parent to Child)");
	}
	@Override
	public void saveDataUsingChild() {
		Person per=new Person("AllisWell","India");
		PhoneNumber ph1=new PhoneNumber(333333333L,"airtel","All");
		PhoneNumber ph2=new PhoneNumber(444444444L,"jio","Personal");
		ph1.setPersonInfo(per);
		ph2.setPersonInfo(per);
		
		Set<PhoneNumber> phonesSet=new HashSet<PhoneNumber>();
		phonesSet.add(ph1);
		phonesSet.add(ph2);
		per.setContactDetails(phonesSet);
		
		
		phoneRepo.save(ph1);
		phoneRepo.save(ph2);
		System.out.println("Person and his associagted phoneNumbers are saved(Child to Parent)");
	}
	@Override
	public void loadDataUsingChild() {
	  Iterable<Person> it= personRepo.findAll();
	  it.forEach(per->{
		  System.out.println("Parent :: "+per);
	  });
		
	}
	@Override
	public String deleteByPerson(int personId) {
	 Optional<Person> opt=personRepo.findById(personId);
	 if(opt.isPresent()) {
		 personRepo.delete(opt.get());
		 return "Person and his PhoneNumbers are deleted";
	 }
	 
	 return "Person not found";
	}
	@Override
	public Void deleteCofPByID(int id) {
	  Optional<Person> opt=personRepo.findById(id);
	  if (opt.isPresent()){
		  Person per=opt.get();
		  System.out.println("P and associated C are deleted");
		  Set<PhoneNumber> c=per.getContactDetails();
		  c.forEach(ph->{
			  ph.setPersonInfo(null);
			  
		  });
		  phoneRepo.deleteAll(c);
		  System.out.println("Only C are deleted");
	  }else {
		  System.out.println(id + "Person not found for deletion");
	  }
	return null;
	}
	@Override
	public Void addNewCtoPByID(int id) {
		 Optional<Person> opt=personRepo.findById(id);
		 if(opt.isPresent()) {
			 Person per=opt.get();
			 Set<PhoneNumber> c=per.getContactDetails();
			 PhoneNumber ph=new PhoneNumber(6666666L,"vi","ALL");
			 //link child to parent
			 ph.setPersonInfo(per);
			 c.add(ph);
			 phoneRepo.save(ph);
			  System.out.println("New C is added to P");
		 }else {
			  System.out.println(id + "Person not found for deletion");
		 }
		return null;
	}

}
