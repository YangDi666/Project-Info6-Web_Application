package tse.info6.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tse.info6.dataModels.Job;

@RepositoryRestResource(collectionResourceRel = "job", path = "job")
public interface JobRepository extends CrudRepository<Job, String>{
	
	public List<Job> findByMinSalaryGreaterThanOrderByMaxSalaryDesc(BigDecimal sal);
	
	//Job findByjobId(@Param("id") String id);
}
