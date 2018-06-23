package jp.co.systena.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jp.co.systena.model.JobListService;


@Controller
public class JobListController {

	@Autowired
	private JobListService jobListService;

	@RequestMapping (value="/HelloWork", method = RequestMethod.GET)
	public String show(Model model) {

		//データを取得し、Viewへの受け渡し用にセットする
		model.addAttribute("jobList", jobListService.getJobList());

		return "JobListView";
	}

}
