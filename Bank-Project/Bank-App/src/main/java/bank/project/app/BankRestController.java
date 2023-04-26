package bank.project.app;

import bank.project.dao.BankService;
import bank.project.dao.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ResourceBundle;


@ComponentScan({"bank.project.dao"})
@RestController
@RequestMapping("/app")
public class BankRestController {
    ResourceBundle bundle = ResourceBundle.getBundle("messages");
    Logger logger = LoggerFactory.getLogger(BankRestController.class);

    @Autowired
    private BankService bankService;

    //Returns current user
    @GetMapping("/username")
    public String currentUserName(Principal principal) {
        return principal.getName();
    }

    //Update customer details
    @PostMapping("/update")
    public int updateProfile(@RequestParam("username") String customerUsername, @RequestParam("contact") long customerContact, @RequestParam("address") String customerAddress, @RequestParam("aadhaar") long customerAadhaar, @RequestParam("pan") String customerPan ){
        logger.info("Recieved update request "+customerUsername);
        Customer customer = new Customer();
        customer.setUsername(customerUsername);
        customer.setContact(customerContact);
        customer.setCustomerAddress(customerAddress);
        customer.setCustomerAadhaar(customerAadhaar);
        customer.setCustomerPan(customerPan);
        return bankService.updateProfile(customer);
    }
}
