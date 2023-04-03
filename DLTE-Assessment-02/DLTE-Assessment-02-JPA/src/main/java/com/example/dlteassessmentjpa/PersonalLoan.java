package com.example.dlteassessmentjpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class PersonalLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "loan_sequence")
    private int loanRequestNumber;
    private int requestedAmount;
    private int cibil;
    private long aadhaar;
    private String pan;
    private String profession;
    private int incomePerAnnum;
    private String statusOfApproval;
    @Temporal(TemporalType.DATE)
    private Date dateOfTheRequest;

}

