package tse.info6.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tse.info6.dataModels.Region;

@RepositoryRestResource(collectionResourceRel = "region", path = "region")
public interface RegionRepository extends JpaRepository<Region, Integer> {
	
	List<Region> findAll();

	Region findByregionId(@Param("id") long id);
}
