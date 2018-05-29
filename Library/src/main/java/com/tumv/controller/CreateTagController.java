package com.tumv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tumv.service.AdminService;

@Controller
public class CreateTagController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/CreateTag", method = RequestMethod.POST)
    public String createTagMapping() {

        return "admin/CreateTag";

    }
}
