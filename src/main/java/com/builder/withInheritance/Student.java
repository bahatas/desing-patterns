package com.builder.withInheritance;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;



@Builder
@Data
public class Student {
    private String name;
    private String surname;
    private String email;
    private int year;
    private long phoneNumber;

}
