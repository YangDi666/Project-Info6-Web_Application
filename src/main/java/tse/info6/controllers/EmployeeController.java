package tse.info6.controllers;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tse.info6.dataModels.Employee;
import tse.info6.repositories.DepartementRepository;
import tse.info6.repositories.EmployeeRepository;
import tse.info6.repositories.JobRepository;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartementRepository departmentRepository;
	
	@Autowired
	private JobRepository jobRepository;
	
	@RequestMapping("/employees")
	public String listEmployees(Model model) {
		
		model.addAttribute("employees", employeeRepository.findAll());
		return "employees/employees";
	}
	
	@RequestMapping("/edit/{id}")
    public String editEmployee(@PathVariable long id, Model model) {
		model.addAttribute("emp", employeeRepository.findByemployeeId(id));
        model.addAttribute("jobs", jobRepository.findAll());
        model.addAttribute("managers", employeeRepository.findAll());
        model.addAttribute("departments", departmentRepository.findAll());
        return "employees/employees_update";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String updateEmployee(@RequestBody MultiValueMap request, Model model) throws ParseException {
		System.out.println(request);
		Employee emp = new Employee();
		emp.setEmployeeId(Long.parseLong((String) ((LinkedList) request.get("employeeId")).getFirst()));
		emp.setFirstName((String) ((LinkedList) request.get("firstName")).getFirst());
		emp.setLastName((String) ((LinkedList) request.get("lastName")).getFirst());
		emp.setEmail((String) ((LinkedList) request.get("email")).getFirst());
		emp.setPhoneNumber((String) ((LinkedList) request.get("phoneNumber")).getFirst());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		emp.setHireDate(dateFormat.parse((String)((LinkedList) request.get("hireDate")).getFirst()));
		emp.setJob(jobRepository.findById((String)((LinkedList) request.get("job.jobId")).getFirst()).get());
		DecimalFormat decimalFormat = new DecimalFormat();
		decimalFormat.setParseBigDecimal(true);
		emp.setSalary((BigDecimal) decimalFormat.parse((String) ((LinkedList) request.get("salary")).getFirst()));
		emp.setCommissionPct((BigDecimal) decimalFormat.parse((String) ((LinkedList) request.get("commissionPct")).getFirst()));
		emp.setManagerId((BigDecimal) decimalFormat.parse((String) ((LinkedList) request.get("managerId")).getFirst()));
		emp.setDepartment(departmentRepository.findBydepartmentId(Long.parseLong((String)((LinkedList) request.get("department.departmentId")).getFirst())));
		employeeRepository.save(emp);
		return "redirect:/" + listEmployees(model);
	}
}
