package com.nhnacademy.edu.springframework.project.config;


import com.nhnacademy.edu.springframework.project.repository.CsvWaterbills;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(exposeProxy = true)
@Configuration
@ComponentScan("com.nhnacademy.edu.springframework.project")
public class MainConfig {
    @Bean
    public CsvWaterbills csvWaterbills(){
        return new CsvWaterbills();
    }

}
