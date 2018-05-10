package com.tumv.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tumv.model.User;
import com.tumv.service.AdminService;

@Controller
public class LoginController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginControllerGet(ModelMap model) throws Exception {
		ArrayList<User> listUser = adminService.getAllUser();
		model.addAttribute("user", listUser.get(0).getUserName());
		return "Login";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String loginControllerPost(ModelMap model) throws Exception {
		ArrayList<User> listUser = adminService.getAllUser();
		model.addAttribute("msg", listUser.get(0).getUserName());
		return "Home";
	}

	@RequestMapping(value = "/Home", method = RequestMethod.GET)
	public String redirectToHome() {
		return "Home";
	}
}
