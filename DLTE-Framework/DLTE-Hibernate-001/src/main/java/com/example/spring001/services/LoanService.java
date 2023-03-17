package com.example.spring001.services;

import com.example.spring001.model.Loans;
import com.example.spring001.remote.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {
    @Autowired
    private LoansRepository loansRepository;

    public List<Loans> implementationOfFindAll(){
        return (List<Loans>) loansRepository.findAll();
    }


    public Loans implementationOfSave(Loans loan){
        return loansRepository.save(loan);

    }

    public String implementOfDeleteById(long loanNumber){
        loansRepository.deleteById(loanNumber);
        return "Deleted";
    }



    public  Optional<Loans> implementOfFindByBorrowerName(String borrowerName){
        return loansRepository.findByBorrowerName(borrowerName);
    }

    public  List<Loans> implementOfFindAllByInterestRate(Integer interestRate){
        return loansRepository.findAllByInterestRate(interestRate);
    }

}
