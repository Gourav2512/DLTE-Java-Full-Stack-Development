package com.example.spring001.remote;

import com.example.spring001.model.Loans;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoansRepository extends CrudRepository<Loans,Long> {
    Optional<Loans> findByBorrowerName(String borrowerName);
    List<Loans> findAllByInterestRate(Integer interestRate);
    @Query("from Loans where interestRate> :min and interestRate< :max")
    List<Loans> findAllByRates(Integer min,Integer max);
}
