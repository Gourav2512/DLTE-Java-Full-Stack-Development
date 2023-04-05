package com.example.dlteassessmentjpa.soap.configs;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class ServiceConfig extends WsConfigurerAdapter {
    @Bean(name = "PersonalLoan")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema officialsSchema){
        DefaultWsdl11Definition schemaObject=new DefaultWsdl11Definition();
        schemaObject.setPortTypeName("LoansPort");
        schemaObject.setTargetNamespace("http://soap.dlte.web.dltespringsoapwebservice");
        schemaObject.setLocationUri("/loanspoint");
        schemaObject.setSchema(officialsSchema);
        return schemaObject;
    }
    @Bean
    public XsdSchema officialsSchema(){
        return new SimpleXsdSchema(new ClassPathResource("loans.xsd"));
    }
    @Bean
    public ServletRegistrationBean servletRegistrationBean(ApplicationContext applicationContext){
        MessageDispatcherServlet servlet=new MessageDispatcherServlet();
        servlet.setTransformWsdlLocations(true);
        servlet.setApplicationContext(applicationContext);
        return new ServletRegistrationBean(servlet,"/loanspoint/*");
    }
}