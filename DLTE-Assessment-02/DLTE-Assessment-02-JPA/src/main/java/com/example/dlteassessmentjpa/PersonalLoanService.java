package com.example.dlteassessmentjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalLoanService {
    @Autowired
    private PersonalLoanRepository personalLoanRepository;

    public List<PersonalLoan> implementOfFetch(){
        return (List<PersonalLoan>) personalLoanRepository.findAll();
    }

    public PersonalLoan implementOfSave(PersonalLoan personalLoan){
        if(personalLoan.getCibil()>700 &&
                (personalLoan.getProfession().equalsIgnoreCase("salaried") ||
                        personalLoan.getProfession().equalsIgnoreCase("self-employed"))
                && personalLoan.getIncomePerAnnum()>=(3*personalLoan.getRequestedAmount())){
            personalLoan.setStatusOfApproval("Approved");
        }
        else
            personalLoan.setStatusOfApproval("Rejected");
        return personalLoanRepository.save(personalLoan);
    }

    public List<PersonalLoan> implementOfFindAllRejected(){
        return personalLoanRepository.findAllRejected();
    }
}
