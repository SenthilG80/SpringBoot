package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	

	private static final String INSERT_EMPLOYEE_QUERY="INSERT INTO EMPLOYEE_INFO VALUES(EID_SEQ1.NEXTVAL,?,?,?,?,?)";

	@Autowired

	private DataSource ds;
	@Override
	public int insert(Employee emp) throws Exception {
		int count=0;
		// TODO Auto-generated method stub
		try(Connection con=ds.getConnection();
		PreparedStatement ps=con.prepareStatement(INSERT_EMPLOYEE_QUERY);){
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getDesg());
			ps.setDouble(3, emp.getSalary());
			ps.setDouble(4, emp.getGrossSalary());
			ps.setDouble(5, emp.getNetSalary());
			count =ps.executeUpdate()	;
	

		}catch (SQLException se) {
			
		se.printStackTrace();
		throw se;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return  count;
	}

}
