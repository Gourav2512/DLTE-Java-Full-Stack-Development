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
    public void testCurrentUsername(){
        when(principal.getName()).thenReturn("Gourav");
        assertEquals("Gourav",bankRestController.currentUserName(principal));
    }
}
