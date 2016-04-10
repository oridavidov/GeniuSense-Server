package com.ori.apps.web.spring.smartsence.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ori.apps.web.spring.smartsence.dao.DataTick;
import com.ori.apps.web.spring.smartsence.dao.User;
import com.ori.apps.web.spring.smartsence.service.DataTickService;
import com.ori.apps.web.spring.smartsence.service.UserService;

@Controller
public class LoginController {

	private UserService userService;
	private DataTickService dataTickService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setDataTickService(DataTickService dataTickService) {
		this.dataTickService = dataTickService;
	}

	@RequestMapping("/")
	public String showIndex() {

		// List<User> users = userService.getAllUsers();

		// model.addAttribute("users", users);

		return "index";
	}

	@RequestMapping("/admin")
	public String showAdmin(Model model) {

		List<User> users = userService.getAllUsers();

		model.addAttribute("users", users);

		return "admin";
	}

	@RequestMapping("/usercreated")
	public String showUserCreated(@Valid User user, BindingResult result) {

		// List<User> users = userService.getAllUsers();
		// model.addAttribute("users", users);
		if (result.hasErrors()) {
			return "register";
		}

		user.setAuthority("ROLE_USER");
		user.setEnabled(1);

		if (userService.exist(user.getUsername())) {
			result.rejectValue("username", "DuplicateKey.user.username",
					"username allready exist...");
			return "register";
		}

		try {
			userService.createUser(user);
		} catch (DuplicateKeyException e) {
			e.printStackTrace();
			// result.rejectValue("username", "DuplicateKey.user.username",
			// "username allready exist...");
			return "register";
		}

		return "usercreated";
	}

	@RequestMapping("/register")
	public String showRegister(Model model) {

		model.addAttribute("user", new User());

		return "register";
	}

	@RequestMapping("/login")
	public String showLogin() {

		return "login";
	}

	@RequestMapping(value = "/getCurrentTime", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	DataTick getCurrentTime() {
		System.out.println("got get request");
		long unixTime = System.currentTimeMillis() / 1000L;

		DataTick time = new DataTick(unixTime);

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("time", time);

		System.out.println("got time request: " + data);
		return time;
	}

	/*
	 * @RequestMapping("/") public ModelAndView showIndex() {
	 * 
	 * ModelAndView mv = new ModelAndView("index"); Map<String, Object> model =
	 * mv.getModel(); model.put("name", "ori davidov"); model.put("type",
	 * "basic");
	 * 
	 * return mv; }
	 */

	@RequestMapping(value = "/getdata", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Map<String, Object> getData(@RequestBody DataTick datatick,
			Principal principal) {
		
		if (datatick != null) {
			/*		
			if (datatick.getMsgType().equals("DATA_TICK")) {
				System.out.println("got dataTick: " + datatick);
				
				if (dataTickService.isUnitRegister(datatick.getUnitId())) {
					System.out.println("unit is registered");
					System.out.println(dataTickService.addDataTick(datatick) + " row added");
				} else {
					System.out.println("unit is not registered");
				}
			}
			else {
				//System.out.println("got unknown msg type: "+datatick.getMsgType());
			}
			*/
		}
		 else {
			System.out.println("got null or unkdataTick object");
		}
		
		////// response /////

		List<DataTick> ticks = null;
		/*
		 * if (principal == null) { ticks = new ArrayList<DataTick>(); } else {
		 */
		// String name = principal.getName();

		ticks = new ArrayList<DataTick>();
		//ticks.add(new DataTick("a1b222", "A", 25.1, 25.2, 60, 60.6, 127, 111111));
		// ticks.add(new DataTick(36.6, 61.0, 125, null));
		// ticks.add(new DataTick(37.7, 62.0, 124, null));

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("dataticks", ticks);
		data.put("size", ticks.size());
		data.put("size2", 123);
		// System.out.println("outgoing data: " + data);
		return data;
	}
}
