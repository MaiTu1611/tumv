package com.tumv.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tumv.model.Book;
import com.tumv.service.AdminService;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/createTag", method = RequestMethod.GET)
    public String createTagMapping() {
        return "admin/CreateTag";

    }

    @RequestMapping(value = "/bookInfo", method = RequestMethod.GET)
    public String bookInfoMapping() {
        return "admin/BookInfo";

    }

    @RequestMapping(value = "/ListBook", method = RequestMethod.GET)
    public String ListBookMapping(ModelMap model) throws Exception {
        ArrayList<Book> listBook = adminService.getAllBook();
        model.addAttribute("listBook", listBook);
        return "admin/ListBook";

    }
}
