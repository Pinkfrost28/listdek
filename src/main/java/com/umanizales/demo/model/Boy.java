package com.umanizales.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class Boy {

    @NotNull
    @NotEmpty
    private String identification;
    @NotNull
    @NotEmpty
    @Size(min =2, max = 50)
    private String name;

    @Positive
    private byte age;
    @NotNull
    private Gender gender;
    @Valid
    @NotNull
    private Location location;

    @NotNull
    @Positive
    @Max(value = 5, message = "Debe ingresar un grado valido")
    private int grade;

    @NotNull
    private boolean orphan;
}
