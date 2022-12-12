package com.builder;


import java.time.Instant;
import java.util.Date;

public class MainMemberBuilder {
    public static void main(String[] args) {
        var memberwithMethod = Members
                .builderMethod(123)
                .membershipStartDate(Date.from(Instant.now()));

        System.out.println(memberwithMethod);


        var memberWithBuilder = Members.mybuilder()
                .membershipNumber(123l)
                .membershipStartDate(Date.from(Instant.now())).build();

        System.out.println(memberWithBuilder);

    }
}
