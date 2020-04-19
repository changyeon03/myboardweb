
package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.SignUpService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String postsignup()throws Exception {
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(HttpServletRequest httpServletRequest, Model model) throws Exception {

        String account = httpServletRequest.getParameter("account");
        String pw = httpServletRequest.getParameter("password");
        String nick_name = httpServletRequest.getParameter("nick_name");

        signUpService.insertUser(account, pw, nick_name);
        return "redirect:/login";
    }
}
