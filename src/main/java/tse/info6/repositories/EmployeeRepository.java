package tse.info6.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tse.info6.dataModels.*;

@RepositoryRestResource(collectionResourceRel = "employee", path = "employee")
public interface EmployeeRepository extends JpaRepository<Employee, String>{
	public ArrayList<Employee> findAllByFirstName(String firstname);
	
	Employee findByemployeeId(@Param("id") long id);
}
