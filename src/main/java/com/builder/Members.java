package com.builder;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder(builderMethodName = "mybuilder")
public class Members {

    private long membershipNumber;
    private Date membershipStartDate;


    public static MembersBuilder builderMethod(long membershipnum) {
        return mybuilder()
                .membershipNumber(membershipnum + 10000);
    }
}