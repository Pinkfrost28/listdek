package com.umanizales.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoysByLocation {
    private Location location;
    private int count;
}
