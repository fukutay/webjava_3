package jp.co.systena.model;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class EntryService {

  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  public Form findEntryById(int id) throws ParseException {
	  
	  //idの情報からデータを取得する
	  List<Map<String, Object>> selectList = 
			  jdbcTemplate.queryForList("SELECT * FROM entry WHERE id = ?", id);
	  
	  //取得したデータをFormにセットする
	  for (Map<String, Object> map : selectList){
		  
		  Form form = new Form(map.get("name").toString(), map.get("motive").toString());
		  
		  return form;
		  
	  } return null;
  }  
}
