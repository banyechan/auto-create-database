package com.banyechan.autocreatedatabase.configuration;


import com.banyechan.autocreatedatabase.controller.Aservlet;
import com.banyechan.autocreatedatabase.controller.Bservlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *   springboot 默认的servlet容器是内嵌的，而自定义的servlet 是无法自动注册进去，
 *      springboot可以通过 ServletRegistrationBean  来把自定义的原始的servlet 注册进去
 */

@Configuration
public class CustomervletConfig {

    @Bean
    public ServletRegistrationBean servletBean() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        registrationBean.addUrlMappings("/a/*");
        registrationBean.setServlet(new Aservlet());
        return registrationBean;
    }

    @Bean
    public ServletRegistrationBean servletB() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        registrationBean.addUrlMappings("/b");
        registrationBean.setServlet(new Bservlet());
        return registrationBean;
    }

}
