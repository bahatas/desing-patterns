package com.task;

import java.util.List;
import java.util.Vector;

public class LongestSubstring {

    //abcadcbb   - > 3
    //bbbbb   - >


    int longestSubString(String given) {

        //iterate through chars

//        put them on a stach while they all uniq
//        if there is dublication

        List<Character> list = new Vector<>();
        String longest = "";
        int result = 0;

        int fastPointer = 0;
        int slowPointer = 0;

        while (fastPointer < given.length()) {


            longest = given.substring(slowPointer, fastPointer);

            fastPointer++;


        }

        return result;

    }
}
