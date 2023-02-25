package com.task.swisscom;

import java.io.IOException;

public class SecurityApp {
    public static void main(String[] args) throws IOException {

        DataService dataService = new DataService(new CsvFileReader());

        //1
        String username = dataService.getUsernameByFirstNameandLastName("Alan", "Smithee");
        dataService.getSeverityOfUserActionByusername(username);
        //2
        String actionType = "Suspicious Activity";
        dataService.getCountOfAction(actionType);
        //3
        dataService.getUserWhoCausedMostSevereIncident();


    }
}
