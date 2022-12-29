package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.AOP.TimeLogging;
import com.nhnacademy.edu.springframework.project.repository.CsvWaterbills;
import com.nhnacademy.edu.springframework.project.repository.Waterbill;
import com.nhnacademy.edu.springframework.project.repository.Waterbills;
import java.util.Collection;
import org.springframework.stereotype.Component;

@Component
public class CsvDataLoadService implements DataLoadService {

    private Waterbills waterbills;

    public CsvDataLoadService(Waterbills waterbills) {
        this.waterbills = waterbills;
    }

    @TimeLogging
    @Override
    public Collection<Waterbill> loadlist(int i) {
        Waterbills waterbills = CsvWaterbills.getInstance();
        waterbills.load();
        Collection<Waterbill> result = waterbills.sectionDevision(i, waterbills.findAll());
        return result;

    }
}

