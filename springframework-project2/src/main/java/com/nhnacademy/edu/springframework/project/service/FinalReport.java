package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.AOP.TimeLogging;
import com.nhnacademy.edu.springframework.project.repository.Waterbills;
import org.springframework.stereotype.Component;

@Component
public class FinalReport implements FinalReports {
    private Waterbills waterbills;
    public FinalReport(Waterbills waterbills) {
        this.waterbills = waterbills;
    }
    @TimeLogging
    public void report(int i){
        CsvCalcService csvCalcService = new CsvCalcService(waterbills);
        System.out.println("------------------------------------------------");
        System.out.println(csvCalcService.calc(i));
        System.out.println("------------------------------------------------");
    }

    }

