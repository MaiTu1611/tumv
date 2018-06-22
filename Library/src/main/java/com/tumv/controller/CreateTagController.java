package com.tumv.controller;

import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tumv.model.Reader;
import com.tumv.service.AdminService;

@Controller
@RequestMapping(value="/service")
public class CreateTagController {

    private static final Logger loggerService = Logger.getLogger(CreateTagController.class);

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/createTag", method = RequestMethod.POST)
    public String createTagMappingPost(@ModelAttribute("createTag")Reader Reader, @RequestParam(value="_csrf", required=false) String _csrf) {
        //System.out.println(reader);
        return "admin/CreateTag";

    }

    public <T> void showAllElement(List<T> elements) {
        for (T element : elements) {
            System.out.println(element);
        }
    }

}
