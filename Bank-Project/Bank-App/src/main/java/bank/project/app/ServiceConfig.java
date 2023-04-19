package bank.project.app;

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
    @Bean(name = "Customer")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema customerSchema){
        DefaultWsdl11Definition schemaObject=new DefaultWsdl11Definition();
        schemaObject.setPortTypeName("customerPort");
        schemaObject.setTargetNamespace("http://bank.project.soap");
        schemaObject.setLocationUri("/soapservice");
        schemaObject.setSchema(customerSchema);
        return schemaObject;
    }

    @Bean
    public XsdSchema customerSchema(){
        return new SimpleXsdSchema(new ClassPathResource("bank.xsd"));
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(ApplicationContext applicationContext){
        MessageDispatcherServlet servlet=new MessageDispatcherServlet();
        servlet.setTransformWsdlLocations(true);
        servlet.setApplicationContext(applicationContext);
        return new ServletRegistrationBean(servlet,"/soapservice/*");
    }
}