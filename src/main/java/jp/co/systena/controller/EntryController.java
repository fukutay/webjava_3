package jp.co.systena.controller;

import java.text.ParseException;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.systena.model.EntryService;
import jp.co.systena.model.Form;


@Controller
public class EntryController {

	@Autowired
	HttpSession session;
	
	@Autowired
	private EntryService entryService;

	@RequestMapping (value="/Entry", method = RequestMethod.GET)
	public ModelAndView show(ModelAndView mav,
							 Form form
							 ) throws ParseException{
		
		int entryId = (int) session.getAttribute("entryId");
		
		//データを取得し、Viewへの受け渡し用にセットする
		form = entryService.findEntryById(entryId);
		mav.addObject("form", form);
		
		//テンプレート指定
		mav.setViewName("EntryView");
		//セッションクリア
		session.invalidate();
		
		return mav;
	}
}
