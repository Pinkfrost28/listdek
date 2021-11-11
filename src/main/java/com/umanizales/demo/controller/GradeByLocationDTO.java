package com.umanizales.demo.controller;

import com.umanizales.demo.model.Location;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GradeByLocationDTO {
    Location location;
    List<GenderByGradeDTO> grades;
}
