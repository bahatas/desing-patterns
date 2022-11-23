package com.threads.exchange;

import java.util.concurrent.Exchanger;

public class ExchangeDemo2 implements Runnable{

    private Exchanger<String> exchanger;
    private String value;

    public ExchangeDemo2(Exchanger<String> exchanger, String value) {
        this.exchanger = exchanger;
        this.value = value;
    }

    @Override
    public void run() {
        try {
            do {
                value = exchanger.exchange(new String());

                if (value != null) {
                    System.out.println(value);
                } else {
                    break;
                }

            } while (true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
