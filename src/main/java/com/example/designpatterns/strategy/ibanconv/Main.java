package com.example.designpatterns.strategy.ibanconv;

public class Main {

     static void main(String[] args) {
        IbanPort sandBox = new IbanSandboxBreakDown();

        Iban local = new Iban(sandBox,"GB 29 NWBK 601613 31926819");
        local.toSortCode();
        local.toAccountNumber();
    }
}
