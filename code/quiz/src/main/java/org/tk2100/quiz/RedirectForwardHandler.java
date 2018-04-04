package org.tk2100.quiz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RedirectForwardHandler {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String redirect(){
        return "redirect:swagger-ui.html";
    }
}
