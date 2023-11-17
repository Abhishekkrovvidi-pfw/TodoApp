package com.abhishek.TodoApp.login;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class WelcomeController {
    //Handles Get Request
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String goTOWelcomePage(ModelMap modelMap) {
        modelMap.put("username", getLoginUserName());
        return "welcome";
    }
    private String getLoginUserName(){
      Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
      return authentication.getName();
    }
}
