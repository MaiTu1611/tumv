package com.tumv.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tumv.model.Book;
import com.tumv.model.Reader;
import com.tumv.service.AdminService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/createTag", method = RequestMethod.GET)
    public String createTagMappingGet(Model model) {
        model.addAttribute("createTag", new Reader());
        return "admin/CreateTag";

    }

    @RequestMapping(value = "/bookInfo", method = RequestMethod.GET)
    public String bookInfoMapping() {
        return "admin/BookInfo";

    }

    @RequestMapping(value = "/listBook", method = RequestMethod.GET)
    public String ListBookMapping(ModelMap model) throws Exception {
        ArrayList<Book> listBook = adminService.getAllBook();
        model.addAttribute("listBook", listBook);
        return "admin/ListBook";

    }

    @RequestMapping(value = "/borrowBook", method = RequestMethod.GET)
    public String BorrowBookMapping(ModelMap model) throws Exception {
        ArrayList<Book> listBook = adminService.getAllBook();
        model.addAttribute("listBook", listBook);
        return "admin/BorrowBook";

    }

    @RequestMapping(value = "/returnBook", method = RequestMethod.GET)
    public String ReturnBookMapping(ModelMap model) throws Exception {
        ArrayList<Book> listBook = adminService.getAllBook();
        model.addAttribute("listBook", listBook);
        return "admin/ReturnBook";

    }

    @RequestMapping(value = "/penalizeBook", method = RequestMethod.GET)
    public String PenalizeBookMapping(ModelMap model) throws Exception {
        ArrayList<Book> listBook = adminService.getAllBook();
        model.addAttribute("listBook", listBook);
        return "admin/PenalizeBook";

    }

    @RequestMapping(value = "/reportBook", method = RequestMethod.GET)
    public String ReportBookMapping(ModelMap model) throws Exception {
        ArrayList<Book> listBook = adminService.getAllBook();
        model.addAttribute("listBook", listBook);
        return "admin/ReportBook";

    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            model.addAttribute("message", "Hi " + principal.getName()
                    + "<br> You do not have permission to access this page!");
        } else {
            model.addAttribute("msg",
                    "You do not have permission to access this page!");
        }
        return "403Page";
    }
}
