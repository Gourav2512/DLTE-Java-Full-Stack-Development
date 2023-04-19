package bank.app.bankapplication;

import dlte.dao.daooperations.BankService;
import dlte.dao.daooperations.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;

@ComponentScan({"dlte.dao.daooperations"})
@RestController
public class BankController {
    @Autowired
    private BankService bankService;

    private Logger logger= LoggerFactory.getLogger(BankController.class);

    @GetMapping("/")
    public List<Customer> callList(){
        logger.info("Controller about print All the records");
        return bankService.listAll();
    }

    @GetMapping("/{user}/{pass}")
    public Optional<Customer> callFindByUser(@PathVariable("user") String username, @PathVariable("pass") String password){
        return bankService.findByUser(username,password);
    }
}
