package tse.info6.controllers;

import java.util.LinkedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tse.info6.dataModels.Country;

import tse.info6.repositories.CountryRepository;
import tse.info6.repositories.RegionRepository;


@Controller
@RequestMapping("/countries")
public class CountryController {
	
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private RegionRepository regionRepository;
	
	@RequestMapping("/countries")
	public String listCountries(Model model) {
		
		model.addAttribute("countries", countryRepository.findAll());
		return "countries/countries";
	}
	
	@RequestMapping("/edit/{id}")
    public String editCountry(@PathVariable String id, Model model) {
        model.addAttribute("country", countryRepository.findBycountryId(id));
        model.addAttribute("regions", regionRepository.findAll());
        return "countries/countries_update";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String updateCountry(@RequestBody MultiValueMap request, Model model) {
		System.out.println(request);
		Country country = new Country();
		country.setCountryId((String) ((LinkedList) request.get("countryId")).getFirst());
		country.setCountryName((String) ((LinkedList) request.get("countryName")).getFirst());
		country.setRegion(regionRepository.findByregionId(Long.parseLong((String)((LinkedList) request.get("region.regionId")).getFirst())));
		country.setLocations(countryRepository.findBycountryId(country.getCountryId()).getLocations());
		countryRepository.save(country);
        return "redirect:/"+listCountries(model);
	}
	

}
