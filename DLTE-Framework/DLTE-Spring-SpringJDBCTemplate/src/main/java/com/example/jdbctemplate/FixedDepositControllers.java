package com.example.jdbctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class FixedDepositControllers {
    @Autowired
    private FixedDepositServices fixedDepositServices;
    @GetMapping("/byamount/{amount}")
    public List<FixedDeposit> callReadByName(@PathVariable("amount") int amount){
        return fixedDepositServices.fetchByDeposit(amount);
    }

    @PutMapping("/update/{id}/{interest}")
    public String callUpdateInterest(@PathVariable("id") int id,@PathVariable("interest") int interest){
        return fixedDepositServices.updateInterest(id,interest);
    }
}
