package com.example.spring001.controls;

import com.example.spring001.model.Loan;
import com.example.spring001.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoanController {
    @Autowired
    private LoanService loanService;

    @GetMapping("/retrieve")
    public List<Loan> callingFindAll(){
        return loanService.implementationOfFindAll();

    }

    @PostMapping("/insert")
    public Loan callingSave(@RequestBody Loan loan){
        return loanService.implementationOfSave(loan);
    }
}
