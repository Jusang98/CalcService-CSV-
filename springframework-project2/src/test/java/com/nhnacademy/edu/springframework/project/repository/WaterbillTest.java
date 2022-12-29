package com.nhnacademy.edu.springframework.project.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WaterbillTest {
    @DisplayName("Trariff.csv 파일에서 데이터를 제대로 읽어오는지 확인")
    @Test
    public void loadTest() {
        ArrayList<Waterbill> waterbillslist = new ArrayList<>();
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
        System.out.println(waterbillslist);
    }

    @Test
    void findAllTest() {
        CsvWaterbills csvWaterbills = new CsvWaterbills();
        csvWaterbills.load();
        int i = 303;
        Assertions.assertThat(csvWaterbills.findAll().size()).isEqualTo(i);
    }
}