package tse.info6.DTO;

import java.io.Serializable;

public class EmployeeDTO implements Serializable{
	private String firstName;
	private String lastName;
	private String departmentName;
	
	public EmployeeDTO(){
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

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
}
