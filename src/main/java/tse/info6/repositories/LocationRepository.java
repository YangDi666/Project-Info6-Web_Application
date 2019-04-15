package tse.info6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tse.info6.dataModels.Location;

@RepositoryRestResource(collectionResourceRel = "location", path = "location")
public interface LocationRepository extends JpaRepository<Location, Integer>{

}
