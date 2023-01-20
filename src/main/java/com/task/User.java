package com.task;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class User {

    @CsvBindByName(column = "Username")
    private String username;
    @CsvBindByName(column = "First name")
    private String firstName;
    @CsvBindByName(column = "Surname")
    private String surname;
}
