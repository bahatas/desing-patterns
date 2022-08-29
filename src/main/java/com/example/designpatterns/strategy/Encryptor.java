package com.example.designpatterns.strategy;

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