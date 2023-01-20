package com.task;

import java.io.IOException;
import java.util.List;

public class SecurityApp {
    public static void main(String[] args) throws IOException {

        DataService dataService = new DataService(new CsvFileReader());

        //1
        String username = dataService.getUsernameByFirstNameandLastName("Alan", "Smithee");
        dataService.getSeverityOfUserActionByusername(username);
        //2
        String actionType = "Suspicious Activity";
        dataService.getCountOfAction(actionType);


    }
}
