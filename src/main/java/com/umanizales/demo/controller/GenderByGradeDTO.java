package com.umanizales.demo.controller;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GenderByGradeDTO {
    int grade;
    List<CountByGenderDTO> genders;
    int total;
}
