package com.tumv.controller;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tumv.model.User;
import com.tumv.service.AdminService;

@Controller
public class LoginController {

    private static final Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginController(ModelMap model) throws Exception {
        return "redirect:/Login";
    }

    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public String loginControllerGet(ModelMap model, @RequestParam(value = "logout", required = false) String logout) throws Exception {
        ArrayList<User> listUser = adminService.getAllUser();
        model.addAttribute("user", listUser.get(0).getUserName());
        logger.debug("getWelcome is executed!");
        if (logout != null) {
            model.addAttribute("msg", "You've been logged out successfully.");
        }
        return "Login";
    }

    @RequestMapping(value = "/Home", method = RequestMethod.GET)
    public String redirectToHome() {
        logger.debug("getWelcome is Home!");
        return "Home";
    }

    @RequestMapping(value = "/home2", method = RequestMethod.GET)
    public ModelAndView homePage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Custom Login Form");
        model.addObject("message", "This is protected page!");
        model.setViewName("home2");

        return model;

    }
}
