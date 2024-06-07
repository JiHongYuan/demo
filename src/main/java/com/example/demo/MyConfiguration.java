package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templateresolver.StringTemplateResolver;


@Configuration
public class MyConfiguration {

    @Bean
    public StringTemplateResolver stringTemplateResolver() {
        return new StringTemplateResolver();
    }

    @Bean
    public StringTemplateEngine stringTemplateEngine() {
        StringTemplateEngine stringTemplateEngine = new StringTemplateEngine();
        stringTemplateEngine.addTemplateResolver(stringTemplateResolver());
        return stringTemplateEngine;
    }

}
