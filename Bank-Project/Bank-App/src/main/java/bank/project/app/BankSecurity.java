package bank.project.app;

import bank.project.dao.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BankSecurity {

    Logger logger = LoggerFactory.getLogger(BankSecurity.class);

    @Autowired
    BankService bankService;

    AuthenticationManager authenticationManager;

    @Autowired
    LoginFailureHandler failureHandler;

    @Autowired
    LoginSuccessHandler successHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        //logger.info("Security Chain:"+httpSecurity);
        //Permitting login(error) pages
        httpSecurity.authorizeRequests().antMatchers("/images/**","/web/login**","/soapservice**").permitAll();
        //Authenticating all pages
        httpSecurity.authorizeRequests().anyRequest().authenticated();
        //Custom login page and handlers
        httpSecurity.formLogin().loginPage("/web/login").usernameParameter("username").failureHandler(failureHandler).successHandler(successHandler).permitAll();
        //Permitting logout
        httpSecurity.logout().logoutSuccessUrl("/web/login").permitAll();
        httpSecurity.csrf().disable();

        AuthenticationManagerBuilder builder=httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(bankService);
        authenticationManager=builder.build();
        httpSecurity.authenticationManager(authenticationManager);

        return httpSecurity.build();
    }
}
