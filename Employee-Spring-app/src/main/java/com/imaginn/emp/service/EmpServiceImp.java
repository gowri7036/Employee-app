package com.imaginn.emp.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import com.imaginn.emp.dto.EmpDto;
import com.imaginn.emp.entity.Emp;
import com.imaginn.emp.exception.MyEmployeeException;
import com.imaginn.emp.repository.EmpRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImp implements EmpService {

	@Autowired
	private EmpRepository employeeRepository;

	@Autowired
	private ModelMapper modelMapper;

	
	

	@Override
	public EmpDto createEmployee( EmpDto employeedto) {
		System.out.println(employeedto);
		Emp employee = modelMapper.map(employeedto, Emp.class);
		EmpDto newDto = null;
		Emp savedemployee = null;
		try {
			savedemployee = employeeRepository.save(employee);

		} catch (Exception e) {
			throw new MyEmployeeException("employee allready existed");
		}
		newDto = modelMapper.map(savedemployee, EmpDto.class);
		return newDto;

	}

	
	
	@Override
	public List<EmpDto> GetAllEmployees(int pageno ,int psgesize, String sortby,String sortdrc) {
		Sort sort =sortdrc.equalsIgnoreCase(Sort.Direction.ASC.name())?
    			Sort.by(sortby).ascending():Sort.by(sortby).descending();
    	
    	Pageable pag = PageRequest.of(pageno, psgesize, sort);
  
    	Page<Emp>allemploylist =employeeRepository.findAll(pag);
    	List<EmpDto>allemploydtolist = allemploylist.stream()
    			.map((Employee)-> modelMapper
    			.map(Employee, EmpDto.class)).collect(Collectors.toList());
    		
		return allemploydtolist;
	}


 

	@Override
	public Double getEmployeeTaxdeductionCurrentFinancialYear(Long id) {
		
		Double tax = 0.0;
		Double cess = 0.0;
	
		Emp employeebyid = employeeRepository.findById(id).get();
				if(employeebyid==null) {
				throw new MyEmployeeException("EmployeeNotFoundException");
				}
				EmpDto employeeDto = modelMapper.map(employeebyid, EmpDto.class);
         LocalDate employeestartingdate = employeeDto.getDOJ();
         LocalDate employeeendingdate =LocalDate.now()  ;
         long totalemployeemonthsworking = ChronoUnit.MONTHS.between(employeestartingdate, employeeendingdate);
	    	Double totalsalaryofemployee = employeeDto.getSalary() *  totalemployeemonthsworking ;

		if (totalsalaryofemployee > 250000 && totalsalaryofemployee<=500000) 
		{

			return tax = (totalsalaryofemployee-250000)*0.05;
			
		}
		else if (totalsalaryofemployee > 500000 && totalsalaryofemployee <= 1000000) 
		{
			return tax = 12500+(totalsalaryofemployee-500000)*0.1;
		}
		else if (totalsalaryofemployee > 1000000 ) 
		{
	
			return tax =112500+(totalsalaryofemployee-1000000)*0.2 ;
		}
	
		
		if(totalsalaryofemployee>2500000) {
			return cess=(totalsalaryofemployee-2500000)*0.02;
		}
		double employeetotaltax =tax+cess;
		
		
		return employeetotaltax; 
	}


	
}
