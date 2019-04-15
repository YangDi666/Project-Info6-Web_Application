package tse.info6.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import tse.info6.DTO.Employee_Sal_DTO;
import tse.info6.dataModels.Employee;
import tse.info6.repositories.EmployeeRepository;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@RequestMapping("/histogram_salary")
	String sal_histogram(Model model) {
		
		ModelMapper modelMapper = new ModelMapper();
		ArrayList<Employee_Sal_DTO> emp_dto_list = new ArrayList<Employee_Sal_DTO>();
		ArrayList<Employee> emp_list = (ArrayList<Employee>) employeeRepository.findAll();
		for(Employee emp : emp_list) {
			Employee_Sal_DTO emp_dto = modelMapper.map(emp, Employee_Sal_DTO.class);
			emp_dto_list.add(emp_dto);
		}
		
		model.addAttribute("emp", emp_dto_list);
		return "statistics/sal_emp";
	}
	
	@RequestMapping("/decile_salary")
	String sal_pie(Model model) {
		
		ModelMapper modelMapper = new ModelMapper();
		ArrayList<BigDecimal> sal_list = new ArrayList<BigDecimal>();
		ArrayList<Employee> emp_list = (ArrayList<Employee>) employeeRepository.findAll();
		for(Employee emp : emp_list) {
			sal_list.add(emp.getSalary());
		}
		
		model.addAttribute("sal", sal_list);
		return "statistics/sal_decile";
	}
	
}
