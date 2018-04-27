package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class MainController extends AbstractController{

    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest paramHttpServletRequest,
            HttpServletResponse paramHttpServletResponse) throws Exception {
        ModelAndView model = new ModelAndView("Home");
        model.addObject("msg", "lOGIN SUCCESS!!!");
        return model;
    }

}