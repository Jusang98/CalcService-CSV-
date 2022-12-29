package com.nhnacademy.edu.springframework.project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.nhnacademy.edu.springframework.project.repository.CsvWaterbills;
import com.nhnacademy.edu.springframework.project.repository.Waterbill;
import com.nhnacademy.edu.springframework.project.repository.Waterbills;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class CalcServiceTest {
    @Test
    public void calc(){
        int i = 100;
        CsvCalcService csvCalcService = new CsvCalcService();
        Waterbills waterRepository = CsvWaterbills.getInstance();
        CsvDataLoadService csvDataLoadService = new CsvDataLoadService(waterRepository);
        Collection<Waterbill> resultlist = csvDataLoadService.loadlist(i);
        assertEquals(resultlist.stream()
            .sorted(Comparator.comparing(Waterbill::getBillTotal))
            .limit(5)
            .collect(Collectors.toList()),csvCalcService.calc(i));

    }
}
