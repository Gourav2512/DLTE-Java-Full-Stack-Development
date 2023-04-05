package com.example.jdbctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class FixedDepositServices {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<FixedDeposit> fetchByDeposit(int amount){
        return jdbcTemplate.query("select * from deposits where deposite_amount=?",new DepositMapper(),amount);
    }

    public String updateInterest(int id, float interest){
        float amount = jdbcTemplate.queryForObject("select deposite_amount from deposits where deposite_id=?",Float.class,id);
        amount = amount + amount*interest/100;
        jdbcTemplate.update("update deposits set interest_rate=?,mature_amount=? where deposite_id=?",interest,amount,id);
        return "updated";
    }

    class DepositMapper implements RowMapper<FixedDeposit> {
        @Override
        public FixedDeposit mapRow(ResultSet rs, int rowNum) throws SQLException {
            FixedDeposit deposit=new FixedDeposit();
            deposit.setDeposite_id(rs.getInt("deposite_id"));
            deposit.setDeposite_amount(rs.getInt("deposite_amount"));
            deposit.setDeposite_tenure(rs.getInt("deposite_tenure"));
            deposit.setDeposite_date(rs.getDate("deposite_date"));
            deposit.setInterest_rate(rs.getInt("interest_rate"));
            deposit.setMature_date(rs.getDate("mature_date"));
            deposit.setMature_amount(rs.getInt("mature_amount"));
            deposit.setMode_of_dividant(rs.getString("mode_of_dividant"));
            return deposit;
        }
    }

}
