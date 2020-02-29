package com.krystiandzik.instangserver;

import com.krystiandzik.instangserver.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.FilterRegistration;


@SpringBootApplication
public class InstangServerApplication {

    @Bean
    public FilterRegistrationBean jwtFilter(){
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/rest/*");
        return registrationBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(InstangServerApplication.class, args);
    }

}
