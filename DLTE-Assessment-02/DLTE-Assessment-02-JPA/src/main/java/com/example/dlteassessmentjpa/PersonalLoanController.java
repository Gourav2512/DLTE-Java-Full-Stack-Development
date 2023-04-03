package com.example.dlteassessmentjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonalLoanController {
    @Autowired
    private PersonalLoanService personalLoanService;

    @GetMapping("/retrieve")
    public List<PersonalLoan> callingFetch(){
        return personalLoanService.implementOfFetch();
    }

    @PostMapping("/insert")
    public PersonalLoan callingSave(@RequestBody PersonalLoan personalLoan){
        return personalLoanService.implementOfSave(personalLoan);
    }

    @GetMapping("/rejected")
    public List<PersonalLoan> callingFindAllRejected(){
        return personalLoanService.implementOfFindAllRejected();
    }
}
