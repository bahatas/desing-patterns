package com.example.strategydesingpattern.strategy;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

class EncryptorTest {
    /**
     * Method under test: {@link Encryptor#Encryptor(EncryptionStrategy)}
     */
    @Test
    void testConstructor() {
        assertNull((new Encryptor(mock(EncryptionStrategy.class))).getPlainText());
    }

    /**
     * Method under test: {@link Encryptor#encrypt()}
     */
    @Test
    void testEncrypt() {
        EncryptionStrategy encryptionStrategy = mock(EncryptionStrategy.class);
        doNothing().when(encryptionStrategy).encryptData((String) any());
        (new Encryptor(encryptionStrategy)).encrypt();
        verify(encryptionStrategy).encryptData((String) any());
    }

    @Test
    public void testEncrypt2() throws Exception {
        EncryptionStrategy aesStrategy=new AesEncryptionStrategy();
        Encryptor aesEncryptor=new Encryptor(aesStrategy);
        aesEncryptor.setPlainText("This is plain text");
        aesEncryptor.encrypt();
        EncryptionStrategy blowfishStrategy=new BlowfishEncryptionStrategy();
        Encryptor blowfishEncryptor=new Encryptor(blowfishStrategy);
        blowfishEncryptor.setPlainText("This is plain text");
        blowfishEncryptor.encrypt();
    }
}

