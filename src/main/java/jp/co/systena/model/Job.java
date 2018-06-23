package jp.co.systena.model;

public class Job {

  private int jobId;
  private String jobName;
  private String jobStatus;
  private int jobSalary;
  
  
  public Job(int id, String name, String status, int salary) {

    this.jobId = id;
    this.jobName = name;
    this.jobStatus = status;
    this.jobSalary = salary;
  }
  
  public Job() {
	  
  }

  public int getJobId() {
    return this.jobId;
  }

  public void setJobId(int jobId) {
    this.jobId = jobId;
  }

  public String getJobName() {
   return this.jobName;
 }

  public void setJobName(String jobName) {
   this.jobName = jobName;
 }

 public String getJobStatus() {
   return this.jobStatus;
 }

 public void setJobStatus(String jobStatus) {
   this.jobStatus = jobStatus;
 }

 public int getJobSalary() {
   return this.jobSalary;
 }

 public void setJobSalary(int jobSalary) {
   this.jobSalary = jobSalary;
 }
}
