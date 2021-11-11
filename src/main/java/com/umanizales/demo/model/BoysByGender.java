package com.umanizales.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoysByGender {
    private Gender gender;
    private int count;
}
