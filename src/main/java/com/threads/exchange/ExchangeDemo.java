package com.threads.exchange;

import java.util.concurrent.Exchanger;

public class ExchangeDemo implements Runnable {


    private Exchanger<String> exchanger;
    private String value;

    public ExchangeDemo(Exchanger<String> exchanger, String value) {
        this.exchanger = exchanger;
        this.value = value;
    }

    @Override
    public void run() {
        char starter = 'a';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                value += starter++;

            }
            try {
                value = exchanger.exchange(value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            exchanger.exchange(null);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

