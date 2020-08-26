package com.legenda.lee.studyurule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ImportResource({"classpath:context.xml"})
public class StudyUruleApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyUruleApplication.class, args);
    }

}
