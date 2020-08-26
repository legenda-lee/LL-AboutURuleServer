package com.legenda.lee.studyurule;

import com.bstek.urule.console.servlet.URuleServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServlet;

/**
 * @author: Legenda-Lee(lee.legenda@gmail.com)
 * @date: 2020-08-14 6:21 下午
 * @description:
 */
@Configuration
public class URuleServletRegistration {

    @Bean
    public ServletRegistrationBean<HttpServlet> registerURuleServlet(){
        return new ServletRegistrationBean<HttpServlet>(new URuleServlet(),"/urule/*");
    }

}
