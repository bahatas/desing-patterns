package com.task;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class SecurityData {

    @CsvBindByName(column = "Name")
    private String name;
    @CsvBindByName(column = "Client")
    private String client;
    @CsvBindByName(column = "Action")
    private String action;
    @CsvBindByName(column = "Impact")
    private int impact;
    @CsvBindByName(column = "Occurrences")
    private int occurence;
    @CsvBindByName(column = "ID")
    private String ID;
}
