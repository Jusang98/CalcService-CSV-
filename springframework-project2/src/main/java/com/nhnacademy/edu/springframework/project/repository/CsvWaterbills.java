package com.nhnacademy.edu.springframework.project.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.stereotype.Component;

@Component
public class CsvWaterbills implements Waterbills {


    private final static CsvWaterbills csvWaterbills = new CsvWaterbills();

    private ArrayList<Waterbill> waterbillslist;


    public CsvWaterbills() {
        waterbillslist = new ArrayList<>();
    }


    public static Waterbills getInstance() {
        return csvWaterbills;
    }


    @Override
    public void load() {
        waterbillslist = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(
            "C:\\Users\\rlatk\\IdeaProjects\\Nhn\\springframework-project2\\src\\main\\resources\\data\\Tariff_20220331.csv"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                waterbillslist.add(new Waterbill(values[1], values[2], Integer.parseInt(values[4]),
                    Integer.parseInt(values[5]), Integer.parseInt(values[6])));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<Waterbill> sectionDevision(int i, Collection<Waterbill> waterbills) {
        Collection<Waterbill> tmp = new ArrayList<>();
        for (Waterbill waterbill : waterbills) {
            if (i >= waterbill.getStart() && i <= waterbill.getFinish()) {
                waterbill.setBillTotal(i * waterbill.getUnitPrice());
                tmp.add(waterbill);
            }
        }
        return tmp;
    }

    @Override
    public Collection<Waterbill> findAll() {
        return waterbillslist;
    }


}


