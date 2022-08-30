package com.example.designpatterns.strategy.ibanconv;

public class IbanSandboxBreakDown implements IbanPort{

    @Override
    public String toSortCode(String iban) {
        String formattedIban = iban.replace(" ", "").trim();
        if(formattedIban.length()!=22){
            throw new IllegalArgumentException("Invalid Iban");
        }
        return formattedIban.substring(8,14);    }

    @Override
    public String toAccountNumber(String iban) {
        String formattedIban = iban.replace(" ","").trim();
        if(formattedIban.length()!=22){
            throw new IllegalArgumentException("Invalid Iban");
        }
        return formattedIban.substring(14);


    }
}
