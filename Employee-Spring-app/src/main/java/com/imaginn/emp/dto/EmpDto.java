package com.imaginn.emp.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;



public class EmpDto {
	
	private Long EmployeeID;
	 @NotNull (message = " required firstname ")
	private String firstname;
	@NotNull (message = " required lastname")
	private String lastname;
	@Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	@NotNull (message = " required Email")
	private String email;
	@NotBlank(message = "required Phone no  ")
	private String phonenumber;
	@NotNull(message = " required Date of joining ")
	private LocalDate doj;

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
		return doj;
	}
	public void setDOJ(LocalDate dOJ) {
		doj = dOJ;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public EmpDto(Long employeeID, @NotBlank(message = " required firstname ") String firstname,
			@NotBlank(message = " required lastname") String lastname,
			@Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$") @NotBlank(message = " required Email") String email,
			@NotBlank(message = "required Phone no  ") String phonenumber,
			@NotNull(message = " required Date of joining ") LocalDate dOJ,
			@NotNull(message = "required Salary") Double salary) {
		super();
		EmployeeID = employeeID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phonenumber = phonenumber;
		doj = dOJ;
		this.salary = salary;
	}
	public EmpDto() {
		super();
	}
	@Override
	public String toString() {
		return "EmployeeDto [EmployeeID=" + EmployeeID + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", phonenumber=" + phonenumber + ", DOJ=" + doj + ", Salary=" + salary + "]";
	}
	
	
	
	
	
}
