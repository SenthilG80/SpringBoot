package com.nt.service;

public interface IOtoMManagementService {
    public void saveDataUsingParent();
    public void saveDataUsingChild();
    public void loadDataUsingChild();
    public String deleteByPerson(int personId);
    public Void deleteCofPByID(int id);
    public Void addNewCtoPByID(int id);
    
}
