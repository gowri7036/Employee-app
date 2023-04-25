package com.imaginn.emp.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Emp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long EmployeeID;
	@Column(nullable = false)
	private String firstname;
	@Column(nullable = false)
	private String lastname;
	@Column(nullable = false,unique = true)
	private String email;
	@Column(nullable = false)
	private String phonenumber;
	@Column(nullable = false)
	private LocalDate DOJ;
	@Column(nullable = false)
	private Double salary;
	public Long getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(Long employeeID) {
		EmployeeID = employeeID;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public LocalDate getDOJ() {
		return DOJ;
	}
	public void setDOJ(LocalDate dOJ) {
		DOJ = dOJ;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Emp(Long employeeID, String firstname, String lastname, String email, String phonenumber, LocalDate dOJ,
			Double salary) {
		super();
		EmployeeID = employeeID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phonenumber = phonenumber;
		DOJ = dOJ;
		this.salary = salary;
	}
	public Emp() {
		super();
	}
	@Override
	public String toString() {
		return "Emp [EmployeeID=" + EmployeeID + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", phonenumber=" + phonenumber + ", DOJ=" + DOJ + ", salary=" + salary + "]";
	}
	

	
	
	
	
	
	
	

	
	

}
