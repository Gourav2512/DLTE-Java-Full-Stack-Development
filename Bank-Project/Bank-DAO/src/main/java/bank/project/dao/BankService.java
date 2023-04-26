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

    //Method to get customer using username
    @Override
    public Customer getByUsername(String username) {
        logger.info("Entered getByUserName: "+username);
        try{
            Customer customer = jdbcTemplate.queryForObject("select * from CUSTOMER where USERNAME=?",new CustomerMapper(),username);
            logger.info("Retrieved customer: "+customer);
            return customer;
        } catch (Exception e) {
            logger.info("Invalid Username");
            return null;
        }
    }

    //Method to get the number of attempts customer is left with
    public int getAttempts(int id) {
        int attempts = jdbcTemplate.queryForObject("select ATTEMPTS from CUSTOMER where CUSTOMER_ID=?",Integer.class,id);
        logger.info("Returned Attempts:"+attempts+"for "+id);
        return attempts;
    }

    //Method to decrease the number attempts
    public void decrementAttempts(int id) {
        jdbcTemplate.update("update CUSTOMER set ATTEMPTS = ATTEMPTS - 1 where CUSTOMER_ID=?",id);
        logger.info("Decreased the number of attempts for" +id);

    }
//    public String getStatus(int id){
//
//    }

    //Method to  reset the attempts to 3
    public void resetAttempts(int id) {
        jdbcTemplate.update("update CUSTOMER set ATTEMPTS=3 where CUSTOMER_ID=?",id);
        logger.info("Set attempts to 3 for "+id);
    }

    //Method to set the status to inactive
    public void setInactive(int id) {
        jdbcTemplate.update("update CUSTOMER set CUSTOMER_STATUS='Inactive' where CUSTOMER_ID=?",id);
        logger.info(id+" :Status set to inactive");
    }

    //Method from UserDetailsService
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer= getByUsername(username);
        if(customer==null){
            throw new UsernameNotFoundException("User doesn't exist");
        }
        if(customer.getCustomerStatus().equalsIgnoreCase("Inactive")){
            throw new UsernameNotFoundException("Your account is deactivated");
        }
        return customer;
    }

    //Method to update the customer details
    @Override
    public int updateProfile(Customer customer){
        logger.info(customer.toString());
        int res = jdbcTemplate.update("update CUSTOMER set CUSTOMER_CONTACT=?, CUSTOMER_ADDRESS=?, CUSTOMER_AADHAAR=?, CUSTOMER_PAN=?, UPDATE_STATUS='Pending' where USERNAME=?",customer.getContact(),customer.getCustomerAddress(),customer.getCustomerAadhaar(),customer.getCustomerPan(),customer.getUsername());
        if(res>0){
            logger.info("Update successful, returned "+res);
        }
        else {
            logger.info("Update declined, returned "+res);
        }
        return res;
    }

    //Customer Mapper Class
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
