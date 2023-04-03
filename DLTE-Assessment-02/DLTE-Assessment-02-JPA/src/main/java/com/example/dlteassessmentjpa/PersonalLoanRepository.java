package com.example.dlteassessmentjpa;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PersonalLoanRepository extends CrudRepository<PersonalLoan,Integer> {

    @Query("from PersonalLoan where statusOfApproval='Rejected'")
    List<PersonalLoan> findAllRejected();

}
