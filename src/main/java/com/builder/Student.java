package com.builder;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Student {
    private String name;
    private String surname;
    private String email;
    private int year;
    private long phoneNumber;

}
