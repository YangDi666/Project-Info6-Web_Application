package tse.info6.dataModels;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the regions database table.
 * 
 */
@Entity
@Table(name="regions")
@NamedQuery(name="Region.findAll", query="SELECT r FROM Region r")
public class Region implements Serializable {
	private static final long serialVersionUID = 1L;
	private long regionId;
	private String regionName;
	private Set<Country> countries;

	public Region() {
	}


	@Id
	@Column(name="REGION_ID", unique=true, nullable=false, precision=10)
	public long getRegionId() {
		return this.regionId;
	}

	public void setRegionId(long regionId) {
		this.regionId = regionId;
	}


	@Column(name="REGION_NAME", length=25)
	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}


	//bi-directional many-to-one association to Country
	@OneToMany(mappedBy="region")
	public Set<Country> getCountries() {
		return this.countries;
	}

	public void setCountries(Set<Country> countries) {
		this.countries = countries;
	}

	public Country addCountry(Country country) {
		getCountries().add(country);
		country.setRegion(this);

		return country;
	}

	public Country removeCountry(Country country) {
		getCountries().remove(country);
		country.setRegion(null);

		return country;
	}

}