package com.imaginn.emp.service;

import java.util.List;

import com.imaginn.emp.dto.EmpDto;

public interface EmpService {
	
	public EmpDto createEmployee(EmpDto dto);

	public 	List<EmpDto> GetAllEmployees(int pageno, int psgesize, String sortby, String sortdrc);
	

	Double getEmployeeTaxdeductionCurrentFinancialYear(Long id);
}
