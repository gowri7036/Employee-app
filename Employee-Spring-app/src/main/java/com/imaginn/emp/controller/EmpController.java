package com.imaginn.emp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.imaginn.emp.dto.EmpDto;
import com.imaginn.emp.service.EmpServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("imaginn/api")
public class EmpController {
	@Autowired
	private EmpServiceImp empServiceImp;

	@PostMapping("/employees")
	public ResponseEntity<?> addemploye(@Validated @RequestBody EmpDto empdto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			Map<String, String> validationsMap = new HashMap<String, String>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				validationsMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(validationsMap, HttpStatus.BAD_REQUEST);

		} else {

			EmpDto newDto = empServiceImp.createEmployee(empdto);

			return new ResponseEntity<EmpDto>(newDto, HttpStatus.CREATED);
		}
	}

	@GetMapping("/employees")
	public ResponseEntity<List<EmpDto>> getallemployee(
			@RequestParam(value = "Pageno", defaultValue = "0", required = false) Integer pageno,
			@RequestParam(value = "pagesize", defaultValue = "2", required = false) Integer pagesize,
			@RequestParam(value = "sotrby", defaultValue = "id", required = false) String sotrby,
			@RequestParam(value = "sotrdsc", defaultValue = "asc", required = false) String sotrdsc) {
		List<EmpDto> employess = empServiceImp.GetAllEmployees(pageno, pagesize, sotrby, sotrdsc);

		return new ResponseEntity<List<EmpDto>>(employess, HttpStatus.OK);

	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<?> getEmployeeTaxDeductionCurrentYear(@PathVariable("id") Long id) {

		return new ResponseEntity<Double>(empServiceImp.getEmployeeTaxdeductionCurrentFinancialYear(id),
				HttpStatus.OK);

	}

}
