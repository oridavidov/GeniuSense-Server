package com.ori.apps.web.spring.smartsence.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ori.apps.web.spring.smartsence.dao.DataTick;
import com.ori.apps.web.spring.smartsence.service.DataTickService;

@Controller
public class DataTickController {
	
	private DataTickService dataTickService;	
	
	@Autowired
	public void setUserService(DataTickService dataTickService) {
		this.dataTickService = dataTickService;
	}
	
	/*
	 * move to a global class for handle all controller
	@ExceptionHandler(DataAccessException.class)
	public String handleDbExceptions(DataAccessException ex) {
		return "dbexeptionerror";
	}
	*/

	@RequestMapping("/dashboard")
	public String showDataTicks(Model model) {	
		
		//List<DataTick> data = dataTickService.throwTestExeption();
		
		List<DataTick> data = dataTickService.getLastDataTicks();
		
		model.addAttribute("dataTicks", data);
		
		return "dashboard";
	}	
	
	// test GET request only with url param
	@RequestMapping(value="/test",
					method=RequestMethod.POST,
					headers = {"Content-type=application/json"})
	public String showTest(Model model, @RequestBody String postPayload) {	
		System.out.println("post data: " + postPayload);
		return "index";
	}	
	/*
	@RequestMapping("/")
	public ModelAndView showIndex() {	
		
		ModelAndView mv = new ModelAndView("index");		
		Map<String, Object> model = mv.getModel();
		model.put("name", "ori davidov");
		model.put("type", "basic");
		
		return mv;
	}
	*/
}
