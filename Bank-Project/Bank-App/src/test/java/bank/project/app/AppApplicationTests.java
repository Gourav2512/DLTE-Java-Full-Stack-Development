package bank.project.app;

import bank.project.dao.BankService;
import bank.project.dao.Customer;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.Principal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
class AppApplicationTests {

    @Mock
    BankService bankService;

    @InjectMocks
    BankRestController bankRestController;

    @Mock
    Principal principal;

    @Test
    public void testUpdateProfile(){
        Customer customer=new Customer(1234,"Gourav","2-14 Bangalore","Active",8787676565l,"gourav1234","gourav@1234",3,234523452345l,"DFGH1234W","Verified");
        when(bankService.updateProfile(eq(customer))).thenReturn(1);
        assertEquals(1,bankRestController.updateProfile("gourav1234",8787676565l,"2-14 Bangalore",234523452345l,"DFGH1234W"));
    }

    @Test
    public void testCurrentUsername(){
        when(principal.getName()).thenReturn("Gourav");
        assertEquals("Gourav",bankRestController.currentUserName(principal));
    }
}
