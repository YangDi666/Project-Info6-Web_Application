package tse.info6.DTO;

import java.math.BigDecimal;

public class Employee_Sal_DTO {
	
	private String firstName;
	private String lastName;
	private BigDecimal salary;
	
	public Employee_Sal_DTO(){
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
}
