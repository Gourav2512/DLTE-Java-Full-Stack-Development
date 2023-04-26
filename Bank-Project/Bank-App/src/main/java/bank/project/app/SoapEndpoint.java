package bank.project.app;

import bank.project.dao.BankService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import soap.project.bank.GetCustomerRequest;
import soap.project.bank.GetCustomerResponse;
import soap.project.bank.SoapCustomer;

@Endpoint
public class SoapEndpoint {
    Logger logger = LoggerFactory.getLogger(SoapEndpoint.class);

    private static final String url = "http://bank.project.soap";

    @Autowired
    BankService bankService;

    //Soap endpoint to view customer details
    @PayloadRoot(namespace = url,localPart = "getCustomerRequest")
    @ResponsePayload
    public GetCustomerResponse getCustomerResponse(@RequestPayload GetCustomerRequest getCustomerRequest){
        logger.info("View Profile: "+getCustomerRequest.getUsername());
        GetCustomerResponse response=new GetCustomerResponse(); //Response object
        SoapCustomer soapCustomer = new SoapCustomer();  //Soap Class Object
        BeanUtils.copyProperties(bankService.getByUsername(getCustomerRequest.getUsername()),soapCustomer);
        response.setCustomer(soapCustomer);
        return response;
    }
}
