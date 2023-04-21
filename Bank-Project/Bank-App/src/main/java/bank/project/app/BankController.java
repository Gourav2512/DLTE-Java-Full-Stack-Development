package bank.project.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@RequestMapping("/web")
public class BankController {

    //Login page controller
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    //Update Profile page controller
    @GetMapping("/update")
    public String update()
    {
        return "updateprofile";
    }

    //View Profile page controller
    @GetMapping("/view")
    public String view()
    {
        return "viewprofile";
    }




}
