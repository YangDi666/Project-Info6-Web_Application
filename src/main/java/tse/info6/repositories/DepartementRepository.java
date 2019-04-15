package tse.info6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tse.info6.dataModels.Department;

@RepositoryRestResource(collectionResourceRel = "department", path = "department")
public interface DepartementRepository extends JpaRepository<Department, Integer>{
	Department findBydepartmentId(@Param("id") long id);
}
