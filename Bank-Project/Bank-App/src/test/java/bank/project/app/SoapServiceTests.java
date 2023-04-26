//package bank.project.app;
//
//import bank.project.dao.BankService;
//import bank.project.dao.Customer;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.webservices.server.WebServiceServerTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.ws.test.server.MockWebServiceClient;
//import org.springframework.xml.transform.StringSource;
//
//import java.io.IOException;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.*;
//
//import static org.springframework.ws.test.server.RequestCreators.withPayload;
//import static org.springframework.ws.test.server.ResponseMatchers.*;
//
//@WebServiceServerTest
//public class SoapServiceTests {
//
//
//    @Autowired
//    MockWebServiceClient mockWebServiceClient;
//
//    @MockBean
//    BankService service;
//
//
//
//    @Test
//    void soapTest() throws IOException {
//        Customer customer = new Customer(123,"Abhishek","2-34 Bangalore","Active",7876765654l,"abhishek1234","abhishek@1234",3,656787654543l,"ACFDF1324R","Verified");
//        when(service.getByUsername("abhishek1234")).thenReturn(customer);
//
//        StringSource request = new StringSource("      <bank:getCustomerRequest xmlns:bank='http://bank.project.soap'>\n" +
//                "         <bank:username>abhishek1234</bank:username>\n" +
//                "      </bank:getCustomerRequest>" );
//
//        StringSource response = new StringSource(
//                "      <ns2:getCustomerResponse xmlns:ns2=\"http://bank.project.soap\">\n" +
//                "         <ns2:customer>\n" +
//                "            <ns2:customerId>123</ns2:customerId>\n" +
//                "            <ns2:customerName>Abhishek</ns2:customerName>\n" +
//                "            <ns2:customerAddress>2-34 Bangalore</ns2:customerAddress>\n" +
//                "            <ns2:customerStatus>Active</ns2:customerStatus>\n" +
//                "            <ns2:contact>7876765654</ns2:contact>\n" +
//                "            <ns2:username>abhishek1234</ns2:username>\n" +
//                "            <ns2:password>abhishek@1234</ns2:password>\n" +
//                "            <ns2:attempts>3</ns2:attempts>\n" +
//                "            <ns2:customerAadhaar>656787654543</ns2:customerAadhaar>\n" +
//                "            <ns2:customerPan>ACFDF1324R</ns2:customerPan>\n" +
//                "            <ns2:updateStatus>Verified</ns2:updateStatus>\n" +
//                "         </ns2:customer>\n" +
//                "      </ns2:getCustomerResponse>"
//                );
//
//        mockWebServiceClient
//                .sendRequest(withPayload(request))
//                .andExpect(noFault())
//                .andExpect(validPayload(new ClassPathResource("bank.xsd")))
//                .andExpect(payload(response));
//    }
//
//
//
//}
