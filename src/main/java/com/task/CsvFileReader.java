package com.task;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Slf4j


public class CsvFileReader {


    //todo add filepath to proprties file

    private final FileReader username = new FileReader("C:\\Users\\User\\IdeaProjects\\JD_PROJECTS\\desing-patterns\\src\\main\\resources\\files\\usernmae.csv");
    private final FileReader test = new FileReader("C:\\Users\\User\\IdeaProjects\\JD_PROJECTS\\desing-patterns\\src\\main\\resources\\files\\test.csv");

    public CsvFileReader() throws FileNotFoundException {
    }


    public List<User> readUserDataFile() throws FileNotFoundException {

        List<User> userList = new CsvToBeanBuilder<User>(username)
                .withType(User.class)
                .build()
                .parse();
        log.info("Read Users count from File : {}", userList.size());

        return userList;

    }

    public List<SecurityData> readSecurityDataFile() throws FileNotFoundException {

        List<SecurityData> dataList = new CsvToBeanBuilder<SecurityData>(test)
                .withType(SecurityData.class)
                .build()
                .parse();
        log.info("Read Users count from File : {}", dataList.size());

        return dataList;

    }

}
