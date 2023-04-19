package bank.project.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class DaoApplicationTests {

    @Mock
    JdbcTemplate jdbcTemplate;

    @InjectMocks
    BankService services;

    @Test
    public void testGetCustomer(){
        Customer c1=new Customer(1234,"Gourav","2-14 Bangalore","Active",8787676565l,"gourav1234","gourav@1234",3,234523452345l,"DFGH1234W","Verified");
        Customer c2=new Customer(1835,"Kirtan","3-27 Mysore","Active",6576789876l,"kirtan1234","kirtan@1234",3,656787654345l,"KJHF3425D","Verified");
        Customer c3=new Customer(1554,"Manvith","3-61V Mangalore","Active",5467865434l,"manvith1234","manvith@1234",3,34234565676l,"LKGU4352W","Verified");
        List<Customer> list = Stream.of(c1,c2,c3).collect(Collectors.toList());
        String username="gourav1234";
        when(jdbcTemplate.queryForObject(eq("select * from CUSTOMER where USERNAME=?"), any(RowMapper.class),eq(username))).thenReturn(list.get(0));
        Customer c=services.getByUsername("gourav1234");
        assertEquals(c1,c);
        assertNotEquals(c3,c);
    }

    @Test
    public void testUpdateProfile(){
        Customer customer=new Customer(1234,"Gourav","2-14 Bangalore","Active",8787676565l,"gourav1234","gourav@1234",3,234523452345l,"DFGH1234W","Verified");
        when(jdbcTemplate.update(eq("update CUSTOMER set CUSTOMER_CONTACT=?, CUSTOMER_ADDRESS=?, CUSTOMER_AADHAAR=?, CUSTOMER_PAN=?, UPDATE_STATUS='Pending' where USERNAME=?"),eq(customer.getContact()),eq(customer.getCustomerAddress()),eq(customer.getCustomerAadhaar()),eq(customer.getCustomerPan()),eq(customer.getUsername()))).thenReturn(1);
        assertEquals(1,services.updateProfile(customer));
    }

    @Test
    public void testGetAttempts(){
        int id = 1234;
        when(jdbcTemplate.queryForObject(eq("select ATTEMPTS from CUSTOMER where CUSTOMER_ID=?"),eq(Integer.class),eq(id))).thenReturn(3);
        assertEquals(3,services.getAttempts(id));
    }

}
