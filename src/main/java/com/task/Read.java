package com.task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Read {


    public static void main(String[] args) throws Exception {

        // File path is passed as parameter
        File file = new File("C:\\Users\\pankaj\\Desktop\\test.txt");

        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)

        // Creating an object of BufferedReader class
        BufferedReader br
                = new BufferedReader(new FileReader(file));

        // Declaring a string variable
        String st;
        // Condition holds true till
        // there is character in a string
        while ((st = br.readLine()) != null)

            // Print the string
            System.out.println(st);
    }
}
