package com.example.spring001.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Loans {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "loan_seq")
    private long loanNumber;
    @Column(nullable = false)
    private String borrowerName;
    @Column(nullable = false)
    private int interestRate;
    @Column(nullable = false)
    private int passedTenure;
    @Column(nullable = false)
    private int failedTenure;
    @Column(nullable = false)
    private int totalTenure;
    @Column(nullable = false)
    private String loanType;
}
