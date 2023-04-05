package com.example.jdbctemplate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FixedDeposit {
    private int deposite_id;
    private int deposite_amount;
    private int deposite_tenure;
    private Date deposite_date;
    private  int interest_rate;
    private Date mature_date;
    private int  mature_amount;
    private String mode_of_dividant;
}
