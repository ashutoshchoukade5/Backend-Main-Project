package com.SringCrud.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.SpringCrud.Model.Employee;

@Component
public class EmployeeDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createProfile(Employee employee) {
		this.hibernateTemplate.save(employee);
	}
	 public List<Employee>getEmployee(){
		 List<Employee>employees= this.hibernateTemplate.loadAll(Employee.class);
		 return employees;
		 
		 
	 }
	 
	 public void deleteEmployee(int eid) {
		  Employee emp=this .hibernateTemplate.load(Employee.class,eid);
		  this.hibernateTemplate.delete(emp);
	 }
	
	 public Employee getEmployee(int eid) {
		 return this.hibernateTemplate.get(Employee.class, eid);
		 
	 }
	 public void update(Employee emp) {
		 hibernateTemplate.update(emp);
	 }
	

}
