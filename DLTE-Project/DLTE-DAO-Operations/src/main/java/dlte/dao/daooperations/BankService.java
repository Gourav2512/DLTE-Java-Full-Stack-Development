package dlte.dao.daooperations;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Customer> listAll(){
        return jdbcTemplate.query("select * from CUSTOMER",new CustomerMapper());
    }

    public Optional<Customer> findByUser(String username, String password){
        return Optional.of(jdbcTemplate.queryForObject("select * from CUSTOMER where USERNAME=? and PASSWORD=?",new CustomerMapper(),username,password));
    }

    class CustomerMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setCustomer_id(rs.getInt("customer_id"));
            customer.setCustomer_name(rs.getString("customer_name"));
            customer.setCustomer_address(rs.getString("customer_address"));
            customer.setContact(rs.getLong("customer_contact"));
            customer.setCustomer_status(rs.getString("customer_status"));
            customer.setUsername(rs.getString("username"));
            customer.setPassword(rs.getString("password"));
            return customer;
        }
    }
}
