package tse.info6.controllers;

import java.util.ArrayList;

import org.hibernate.mapping.Map;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tse.info6.DTO.EmployeeDTO;
import tse.info6.dataModels.Employee;
import tse.info6.repositories.EmployeeRepository;


@RestController
@RequestMapping(path = "/employee")
public class EmployeeRestController {

	@Autowired
	private EmployeeRepository employeerepository;
	
	@RequestMapping(path = "/find_employeeDTO_by_firstname", method = RequestMethod.GET, produces = "application/json")
	public  @ResponseBody ResponseEntity<ArrayList<EmployeeDTO>> getemployeeDTOlist (@RequestParam String firstname) {
		
		ModelMapper modelMapper = new ModelMapper();
		
		ArrayList<EmployeeDTO> emp_dto_list = new ArrayList<EmployeeDTO>();
		ArrayList<Employee> emp_list = employeerepository.findAllByFirstName(firstname);
		for(Employee emp : emp_list) {
			EmployeeDTO emp_dto = modelMapper.map(emp, EmployeeDTO.class);
			emp_dto_list.add(emp_dto);
		}
		
		return new ResponseEntity<ArrayList<EmployeeDTO>>(emp_dto_list, HttpStatus.OK);
	}

}
