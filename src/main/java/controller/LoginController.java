package controller;

import dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public String page()
    {
        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin()
    {
        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String postLogin(HttpServletRequest httpServletRequest, UserDTO user)
    {
        HttpSession session = httpServletRequest.getSession();
        if(loginService.isUser(user)) {
            session.setAttribute("userName", user.getAccount());
            return "/board/list";
        }
        else {
            session.setAttribute("userName", null);
            return "redirect:/login";
        }
    }
}