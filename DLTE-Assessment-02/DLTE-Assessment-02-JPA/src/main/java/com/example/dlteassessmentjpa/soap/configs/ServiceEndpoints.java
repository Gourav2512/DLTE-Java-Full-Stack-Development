package com.example.dlteassessmentjpa.soap.configs;

import com.example.dlteassessmentjpa.PersonalLoan;
import com.example.dlteassessmentjpa.PersonalLoanService;
import dltespringsoapwebservice.web.dlte.soap.ListLoansRequest;
import dltespringsoapwebservice.web.dlte.soap.ListLoansResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Endpoint
public class ServiceEndpoints {
    private static final String url = "http://soap.dlte.web.dltespringsoapwebservice";

    @Autowired
    private PersonalLoanService personalLoanService;

    @PayloadRoot(namespace = url,localPart = "listLoansRequest")
    @ResponsePayload
    public ListLoansResponse listLoansResponse(@RequestPayload ListLoansRequest listLoansRequest){
        ListLoansResponse response=new ListLoansResponse();

        List<PersonalLoan> jpaComponent = personalLoanService.implementOfFetch();// pojo objects
        List<dltespringsoapwebservice.web.dlte.soap.PersonalLoan> loansList=new ArrayList<>();// xml list of objects as of its empty

        Iterator<PersonalLoan> it= jpaComponent.iterator();
        while(it.hasNext()){
            dltespringsoapwebservice.web.dlte.soap.PersonalLoan loan = new dltespringsoapwebservice.web.dlte.soap.PersonalLoan();// XSD POJO
            BeanUtils.copyProperties(it.next(),loan);
            loansList.add(loan);
        }

        response.getLoan().addAll(loansList);

        return response;
    }
}

