package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.AOP.TimeLogging;
import com.nhnacademy.edu.springframework.project.repository.CsvWaterbills;
import com.nhnacademy.edu.springframework.project.repository.Waterbills;
import com.nhnacademy.edu.springframework.project.repository.Waterbill;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CsvCalcService implements CalcServices {

    private Waterbills waterbills;

    public CsvCalcService(Waterbills waterbills) {
        this.waterbills = waterbills;
    }

    public CsvCalcService() {

    }


    @TimeLogging
    @Override
    public Collection<Waterbill> calc(int i) {
        Waterbills waterRepository = CsvWaterbills.getInstance();
        CsvDataLoadService csvDataLoadService = new CsvDataLoadService(waterRepository);
        Collection<Waterbill> resultlist = csvDataLoadService.loadlist(i);

        return resultlist.stream()
            .sorted(Comparator.comparing(Waterbill::getBillTotal))
            .limit(5)
            .collect(Collectors.toList());
    }
}
