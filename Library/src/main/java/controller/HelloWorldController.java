package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView helloWorld(){

        ModelAndView model = new ModelAndView("Login");
        model.addObject("msg", "hello world");

        return model;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView helloWorld2(){

        ModelAndView model = new ModelAndView("Home");
        model.addObject("msg", "hello world");

        return model;
    }

}
