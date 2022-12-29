package com.nhnacademy.edu.springframework.project.repository;

import java.util.Collection;

public interface Waterbills {
    void load();
    Collection<Waterbill> sectionDevision(int i, Collection<Waterbill> waterbills);
    Collection<Waterbill> findAll();

}
