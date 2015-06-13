package com.levelup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    // register filter with spring
    @Bean
    public ReplaceHTMLFilter replaceHtmlFilter() {
    	return new ReplaceHTMLFilter();
    }
}
