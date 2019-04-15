package tse.info6.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tse.info6.dataModels.*;
import tse.info6.repositories.JobRepository;

@RestController
@RequestMapping(value = "/job")
public class JobRestController {

	@Autowired
	private JobRepository jobRepository;
	
	
	@RequestMapping(value = "/find_jobs_with_minimum_salary", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity getjobsaboveminsal(@RequestBody BigDecimal minsal) {
		ArrayList<Job> job_list = (ArrayList<Job>) jobRepository.findByMinSalaryGreaterThanOrderByMaxSalaryDesc(minsal);
		return new ResponseEntity(job_list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity updateJob(@PathVariable String id, @RequestBody String job_title){
		
		Job job = jobRepository.findById(id).get();
        job.setJobTitle(job_title);
        jobRepository.save(job);

        return new ResponseEntity("Job " + id + " has been updated to a new title : \"" + job.getJobTitle() + "\" successfully", HttpStatus.OK);
    }
}
