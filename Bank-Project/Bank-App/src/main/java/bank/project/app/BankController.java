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
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
    @GetMapping("/dashboard")
    public String dash()
    {
        return "dashboard";
    }
    @GetMapping("/update")
    public String update()
    {
        return "updateprofile";
    }

    @GetMapping("/view")
    public String view()
    {
        return "viewprofile";
    }




}
