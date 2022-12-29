package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.Waterbill;
import java.util.Collection;
import org.springframework.stereotype.Component;

@Component
public interface CalcServices {
    Collection<Waterbill> calc(int i);

}
