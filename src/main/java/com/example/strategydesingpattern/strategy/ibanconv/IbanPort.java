package com.example.strategydesingpattern.strategy.ibanconv;

public interface IbanPort {

    String toSortCode();
    String toAccountNumber();
}
