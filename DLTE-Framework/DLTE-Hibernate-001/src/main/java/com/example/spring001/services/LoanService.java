package com.example.spring001.services;

import com.example.spring001.model.Loan;
import com.example.spring001.remote.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

    public List<Loan> implementationOfFindAll(){
        return (List<Loan>) loanRepository.findAll();
    }

    public Loan implementationOfSave(Loan loan){
        return loanRepository.save(loan);
    }
}
