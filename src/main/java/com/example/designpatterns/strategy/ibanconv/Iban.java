package com.example.designpatterns.strategy.ibanconv;

public class Iban {

    private  String iban;
    private IbanPort ibanPort;

    public Iban(IbanPort ibanPort,final String iban) {
        this.ibanPort = ibanPort;
        this.iban = iban;
    }

    public  String toSortCode(){
        return ibanPort.toSortCode(iban);
    }

    public String toAccountNumber(){
        return ibanPort.toAccountNumber(iban);
    }

}
