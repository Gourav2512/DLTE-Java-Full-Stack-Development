package bank.project.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class BankService implements BankOperations, UserDetailsService {

    Logger logger = LoggerFactory.getLogger(BankService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Customer getByUsername(String username) {
        logger.info("Entered getByUserName");
        try{
            Customer customer = jdbcTemplate.queryForObject("select * from CUSTOMER where USERNAME=?",new CustomerMapper(),username);
            return customer;
        } catch (Exception e) {
            logger.info("Exception occured:",e);
            return null;
        }
    }

    public int getAttempts(int id) {
        int attempts = jdbcTemplate.queryForObject("select ATTEMPTS from CUSTOMER where CUSTOMER_ID=?",Integer.class,id);
        logger.info("Returned Attempts");
        return attempts;
    }


    public void decrementAttempts(int id) {
        jdbcTemplate.update("update CUSTOMER set ATTEMPTS = ATTEMPTS - 1 where CUSTOMER_ID=?",id);
        logger.info("Decreased the number of attempts");
        updateStatus();

    }


    public void setAttempts(int id) {
        jdbcTemplate.update("update CUSTOMER set ATTEMPTS=3 where CUSTOMER_ID=?",id);
        logger.info("Set attempts to 3");
    }


    public void updateStatus() {
        jdbcTemplate.update("update CUSTOMER set CUSTOMER_STATUS='Inactive' where ATTEMPTS=0");
        logger.info("Status set to inactive");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Entered loadByUserName");
        Customer customer= getByUsername(username);
        if(customer==null){
            throw new UsernameNotFoundException("User doesn't exist");
        }
        return customer;
    }

    @Override
    public int updateProfile(Customer customer){
        logger.info(customer.toString());
        int res = jdbcTemplate.update("update CUSTOMER set CUSTOMER_CONTACT=?, CUSTOMER_ADDRESS=?, CUSTOMER_AADHAAR=?, CUSTOMER_PAN=?, UPDATE_STATUS='Pending' where USERNAME=?",customer.getContact(),customer.getCustomerAddress(),customer.getCustomerAadhaar(),customer.getCustomerPan(),customer.getUsername());
        logger.info("Update Status: "+res);
        return res;
    }

    static class CustomerMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setCustomerId(rs.getInt("customer_id"));
            customer.setCustomerName(rs.getString("customer_name"));
            customer.setCustomerAddress(rs.getString("customer_address"));
            customer.setContact(rs.getLong("customer_contact"));
            customer.setCustomerStatus(rs.getString("customer_status"));
            customer.setUsername(rs.getString("username"));
            customer.setPassword(rs.getString("password"));
            customer.setAttempts(rs.getInt("attempts"));
            customer.setCustomerAadhaar(rs.getLong("customer_aadhaar"));
            customer.setCustomerPan(rs.getString("customer_pan"));
            customer.setUpdateStatus(rs.getString("update_status"));
            return customer;
        }
    }
}
