package com.ori.apps.web.spring.smartsence.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ori.apps.web.spring.smartsence.dao.DataTick;
import com.ori.apps.web.spring.smartsence.dao.Response;
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
	
	@RequestMapping(value = "/postdatatick", method = RequestMethod.POST, produces = "application/json", headers = {"Content-type=application/json"})
	@ResponseBody
	public Response postDataTick(@Valid @RequestBody DataTick datatick
			, BindingResult result) {
		
			Response response = new Response();
			System.out.println(datatick);
			
			if (result.hasErrors()) {
				System.out.println("Error: " + result.toString());					
				response.setResult("JSON Parsing validation error");				
			}
			else {
				if (dataTickService.isUnitRegister(datatick.getUnitId())) {
					if (dataTickService.addDataTick(datatick)) {
						System.out.println("datatich was commited to DB");
						response.setResult("OK");
					}
					else {
						response.setResult("Error Commit JSON to server");
					}
				}
				else {
					response.setResult("Unit not registered");											
				}								
			}			
			return response;
	}

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
