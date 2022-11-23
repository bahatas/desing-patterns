package com.threads.exchange;

import java.util.concurrent.Exchanger;

public class ExchangerDemoMain {
    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();

        ExchangeDemo task1 = new ExchangeDemo(exchanger, new String());
        ExchangeDemo2 task2 = new ExchangeDemo2(exchanger, new String());

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}
/**
 * Bu örnekte iki threadin birbirine nasıl veri gönderdiğini gördük.
 * Yarattığımız threadlerden birisi iç içe for döngüleri ile 3 harften oluşan
 * kelimeler üretirken diğer thread o verileri alarak ekrana yazdırdı.
 * Exchanger ile bir nevi producer-consumer konseptini implemente etmiş olduk.
 */