package com.task.swisscom;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.Comparator;


@Slf4j
@Service
public class DataService {


    private CsvFileReader fileReader;

    public DataService(CsvFileReader fileReader) {
        this.fileReader = fileReader;
    }

    /**
     * @return username
     */

    public String getUsernameByFirstNameandLastName(String firstName, String lastName) throws FileNotFoundException {

        String username = fileReader.readUserDataFile()
                .stream()
                .filter(user -> user.getFirstName().equals(firstName) &&
                        user.getSurname().equals(lastName))
                .findFirst()
                .get().getUsername();

        log.info("username found :{} ", username);
        return username;

    }

    /**
     * @AlanSmithee is already on thin ice, and I want to know if he has done anything bad.
     * * If he has, I want to know how severe it is.tion
     */
    public int getSeverityOfUserActionByusername(String username) throws FileNotFoundException {
        Integer severityOfUser = fileReader.readSecurityDataFile()
                .stream()
                .filter(securityData -> securityData.getName().equals(username))
                .map(data -> data.getImpact() * data.getOccurence())
                .max(Comparator.naturalOrder())
                .get();

        log.info("severity calculated for user {} is {}", username, severityOfUser);
        return severityOfUser;

    }

    /**
     * I want to know how many data leaks we've had.
     */
    public long getCountOfAction(String actionType) throws FileNotFoundException {

        long countOfActionType = fileReader.readSecurityDataFile()
                .stream().filter(securityData -> securityData.getAction().equals(actionType))
                .map(securityData -> securityData.getOccurence())
                .reduce(0, (a, b) -> a + b).intValue();

        log.info("Action type is {} and count is: {}", actionType, countOfActionType);

        return countOfActionType;

    }


    /**
     * I want to know what our most severe incident was and who caused it.
     */
    public String getUserWhoCausedMostSevereIncident() throws FileNotFoundException {
        String username = fileReader.readSecurityDataFile()
                .stream()
                .sorted(Comparator.comparing(data -> data.getOccurence() * data.getImpact()))
                .findFirst().get().getName();


        User foundUser = fileReader.readUserDataFile().stream().filter(user -> user.getUsername().equals(username)).findFirst().get();
        String usernameAndSurname = foundUser.getUsername() + " " + foundUser.getSurname();
        log.info("Founded user is {}", usernameAndSurname);

        return usernameAndSurname;


    }
}
