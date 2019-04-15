package tse.info6.dataModels;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the jobs database table.
 * 
 */
@Entity
@Table(name="jobs")
@NamedQuery(name="Job.findAll", query="SELECT j FROM Job j")
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;
	private String jobId;
	private String jobTitle;
	private BigDecimal maxSalary;
	private BigDecimal minSalary;
	private Set<Employee> employees;
	private Set<JobHistory> jobHistories;

	public Job() {
	}


	@Id
	@Column(name="JOB_ID", unique=true, nullable=false, length=10)
	public String getJobId() {
		return this.jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}


	@Column(name="JOB_TITLE", nullable=false, length=35)
	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	@Column(name="MAX_SALARY", precision=10)
	public BigDecimal getMaxSalary() {
		return this.maxSalary;
	}

	public void setMaxSalary(BigDecimal maxSalary) {
		this.maxSalary = maxSalary;
	}


	@Column(name="MIN_SALARY", precision=10)
	public BigDecimal getMinSalary() {
		return this.minSalary;
	}

	public void setMinSalary(BigDecimal minSalary) {
		this.minSalary = minSalary;
	}


	//bi-directional many-to-one association to Employee
	@JsonIgnore
	@OneToMany(mappedBy="job")
	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setJob(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setJob(null);

		return employee;
	}


	//bi-directional many-to-one association to JobHistory
	@JsonIgnore
	@OneToMany(mappedBy="job")
	public Set<JobHistory> getJobHistories() {
		return this.jobHistories;
	}

	public void setJobHistories(Set<JobHistory> jobHistories) {
		this.jobHistories = jobHistories;
	}

	public JobHistory addJobHistory(JobHistory jobHistory) {
		getJobHistories().add(jobHistory);
		jobHistory.setJob(this);

		return jobHistory;
	}

	public JobHistory removeJobHistory(JobHistory jobHistory) {
		getJobHistories().remove(jobHistory);
		jobHistory.setJob(null);

		return jobHistory;
	}

}