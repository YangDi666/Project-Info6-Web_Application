package tse.info6.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tse.info6.dataModels.Country;

@RepositoryRestResource(collectionResourceRel = "country", path = "country")
public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {

	List<Country> findBycountryName(@Param("name") String name);
	
	List<Country> findAll();
	
	Country findBycountryId(String id);

}