package com.nhnacademy.edu.springframework.project;


import com.nhnacademy.edu.springframework.project.service.DataLoadService;

import com.nhnacademy.edu.springframework.project.service.CalcServices;
import com.nhnacademy.edu.springframework.project.service.FinalReports;
import java.util.Scanner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Main {


    public static void main(String[] args) {
        System.out.println("사용량 입력");
        Scanner sc  = new Scanner(System.in);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.nhnacademy.edu.springframework.project");
        int i = sc.nextInt();
        context.getBean("csvDataLoadService",DataLoadService.class).loadlist(i);
        context.getBean("csvCalcService", CalcServices.class).calc(i);
        context.getBean("finalReport", FinalReports.class).report(i);

    }
}
