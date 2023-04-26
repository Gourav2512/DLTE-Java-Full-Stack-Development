package bank.project.app;

import bank.project.dao.BankService;
import bank.project.dao.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@Component
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Autowired
    BankService bankService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        ResourceBundle bundle = ResourceBundle.getBundle("messages");
        String userName=request.getParameter("username");
        Customer customer= bankService.getByUsername(userName);
        if(customer!=null) {
           //Check if the account is active
            if(customer.getCustomerStatus().equalsIgnoreCase("Active")){
                bankService.decrementAttempts(customer.getCustomerId());   //Decreasing the number of attempts
                //Getting the number of attempts the user is left with
                int attempts = bankService.getAttempts(customer.getCustomerId());
                if(attempts==2){
                    logger.info(userName+": "+bundle.getString("inPass")+bundle.getString("attempt1"));
                    super.setDefaultFailureUrl("/web/login?error=" + bundle.getString("inPass")+bundle.getString("attempt1"));
                }
                else if(attempts==1){
                    logger.info(userName+": "+bundle.getString("inPass")+bundle.getString("attempt2"));
                    super.setDefaultFailureUrl("/web/login?error=" + bundle.getString("inPass")+bundle.getString("attempt2"));
                }
                else {
                    bankService.setInactive(customer.getCustomerId());
                    logger.info(userName+": "+bundle.getString("inPass")+bundle.getString("inactive"));
                    super.setDefaultFailureUrl("/web/login?error=" +bundle.getString("inPass")+ bundle.getString("inactive"));

                }
            }else {
                logger.info(userName+": "+bundle.getString("inactive"));
                super.setDefaultFailureUrl("/web/login?error=" + bundle.getString("inactive"));  //User is inactive
            }
        }
        else {
            logger.info(exception);
            super.setDefaultFailureUrl("/web/login?error=" +bundle.getString("notExist") ); //username doesn't exist
        }
        super.onAuthenticationFailure(request, response, exception);
    }
}