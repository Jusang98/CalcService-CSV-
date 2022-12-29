package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvWaterbills;
import com.nhnacademy.edu.springframework.project.repository.Waterbills;
import com.nhnacademy.edu.springframework.project.repository.Waterbill;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReportTest {

    private Waterbills waterbills;

    @Test
    public void report(){
        int i = 100;
        Waterbills waterRepository = CsvWaterbills.getInstance();
        CsvDataLoadService csvDataLoadService = new CsvDataLoadService(waterRepository);
        Collection<Waterbill> resultlist = csvDataLoadService.loadlist(i);
        CsvCalcService csvCalcService = new CsvCalcService(waterbills);
        assertEquals(resultlist.stream()
            .sorted(Comparator.comparing(Waterbill::getBillTotal))
            .limit(5)
            .collect(Collectors.toList()),csvCalcService.calc(i));
    }

}