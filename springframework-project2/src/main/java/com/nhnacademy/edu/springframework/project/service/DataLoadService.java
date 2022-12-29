package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.Waterbill;
import java.util.Collection;
import org.springframework.stereotype.Component;

@Component
public interface DataLoadService {
    Collection<Waterbill> loadlist(int i);
}
