package jp.co.systena.controller;

import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jp.co.systena.model.Form;
import jp.co.systena.model.Job;
import jp.co.systena.model.JobListService;


@Controller
public class FormController {

	@Autowired
	HttpSession session;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private JobListService jobListService;
	
	@RequestMapping (value="/EntryForm", method = RequestMethod.GET)
	public ModelAndView show(ModelAndView mav,
                            Job job,
                            String status,
                            @RequestParam(name = "id", required = true) int id
                            ) {
		
		//データを取得し、Viewへの受け渡し用にセットする
		job = jobListService.findJobById(id);
		mav.addObject("form", job);
		
		status = job.getJobStatus();
		
		//テンプレート指定
		if (status.equals("正社員")) {
			mav.setViewName("EntryFormView01");
		}
		if (status.equals("契約社員")) {
			mav.setViewName("EntryFormView02");
		}
		
		return mav;
	}

	@RequestMapping (value="/Entry", method = RequestMethod.POST)
	public String send(
			@ModelAttribute Form form,
			BindingResult result,
			Model model) {
		
		//画面入力値にエラーがない場合
		if (!result.hasErrors()) {
			
			Random rnd= new Random();
			int entryId = rnd.nextInt(10000);
			
			int insertForm = jdbcTemplate.update(
		              "INSERT INTO entry VALUES( ?, ?, ?, ? )",
		              entryId,
		              form.getName().toString(),
		              form.getMotive().toString(),
		              new Date()
					);
			
			//セッションを保存
			session.setAttribute("entryId", entryId);
		}
		//リダイレクト
		return "redirect:/Entry";
	}
}
