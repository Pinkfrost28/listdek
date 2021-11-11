package com.umanizales.demo.controller;


import com.umanizales.demo.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountByGenderDTO {
    Gender gender;
    int count;
}
