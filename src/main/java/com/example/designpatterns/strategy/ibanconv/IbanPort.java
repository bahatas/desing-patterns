package com.example.designpatterns.strategy.ibanconv;

public interface IbanPort {

    String toSortCode(String iban);
    String toAccountNumber(String iban);
}
