package com.example.spring001.controls;

import com.example.spring001.model.Loans;
import com.example.spring001.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LoansController {
    @Autowired
    private LoanService loansService;

    @GetMapping("/retrieve")
    public List<Loans> callingFindAll(){
        return loansService.implementationOfFindAll();

    }

    @PostMapping("/insert")
    public Loans callingSave(@RequestBody Loans loan){
        return loansService.implementationOfSave(loan);
    }

    @DeleteMapping("/suspend/{loanNumber}")
    public String callDeleteById(@PathVariable("loanNumber") long loanNumber){
        return loansService.implementOfDeleteById(loanNumber);
    }

    @GetMapping("/name/{borrowerName}")
    public  Optional<Loans> callingFindByLoanName(@PathVariable("borrowerName") String borrowerName){
        return loansService.implementOfFindByBorrowerName(borrowerName);
    }

    @GetMapping("/rate/{interestRate}")
    public  List<Loans> callingFindAllByInterestRate(@PathVariable("interestRate") Integer interestRate){
        return loansService.implementOfFindAllByInterestRate(interestRate);
    }


}
