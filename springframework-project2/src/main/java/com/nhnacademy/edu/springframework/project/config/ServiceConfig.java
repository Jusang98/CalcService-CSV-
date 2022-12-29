package com.nhnacademy.edu.springframework.project.config;

import com.nhnacademy.edu.springframework.project.service.CsvCalcService;
import com.nhnacademy.edu.springframework.project.service.CsvDataLoadService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(exposeProxy = true)

public class ServiceConfig {
    private MainConfig mainconfig;

    @Bean
    public CsvDataLoadService csvDataLoadService(){
    return new CsvDataLoadService(mainconfig.csvWaterbills());
    }
    @Bean
    public CsvCalcService csvCalcService(){
        return new CsvCalcService(mainconfig.csvWaterbills());
    }


}
