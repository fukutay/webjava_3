package jp.co.systena.model;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class JobListService {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Valid
  private List<Job> jobList;
  
  public List<Job> getJobList() {
	  
	  //SELECTを使用してテーブルの情報をすべて取得する
	  jobList = jdbcTemplate.query("SELECT * FROM jobs ORDER BY job_id", new BeanPropertyRowMapper<Job>(Job.class));
	  
	  return jobList;
  }
  
  public Job findJobById(int id) {
	  
	  //idの情報からデータを取得する
	  List<Map<String, Object>> selectList = 
			  jdbcTemplate.queryForList("SELECT * FROM jobs WHERE job_id = ?", id);
	  
	  //取得したデータをJobにセットする
	  for (Map<String, Object> map : selectList){
		  
		  //objectをintに変換
		  String strId = map.get("job_id").toString();
		  int jobId = new Integer(strId).intValue();
		  String strSalary = map.get("job_salary").toString();
		  int jobSalary = new Integer(strSalary).intValue();
		  
		  Job job = new Job(jobId, map.get("job_name").toString(), map.get("job_status").toString(), jobSalary);
		  
		  return job;
		  
	  } return null;
  }  
}
