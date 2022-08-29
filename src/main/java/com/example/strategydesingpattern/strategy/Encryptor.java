package com.example.strategydesingpattern.strategy;

import lombok.Data;

@Data
public class Encryptor {
    private EncryptionStrategy encryptionStrategy;
    private String plainText;

    public Encryptor(EncryptionStrategy encryptionStrategy) {
        this.encryptionStrategy = encryptionStrategy;
    }


    public void encrypt() {
        encryptionStrategy.encryptData(plainText);
    }


}