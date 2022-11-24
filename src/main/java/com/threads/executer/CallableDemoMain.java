package com.threads.executer;

import java.util.concurrent.*;

public class CallableDemoMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Main Thread Getstarted ");

        int value = 10;

        Callable<Integer> factorial = () -> {
            int result = 1;
            for (int i = 1; i <= value; i++) {
                result *= i;
            }
            Thread.sleep(6000);
            return result;

        };

        Callable<Integer> sum = () -> {
            int result = 0;
            for (int i = 0; i < value; i++) {
                result += i;

            }
            Thread.sleep(10000);
            return result;
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> submitfactorial = executorService.submit(factorial);
        Future<Integer> submitSum = executorService.submit(sum);

        System.out.println("Future results are being collected");
        System.out.println("Factorial of " + value + " is " + submitfactorial.get());
        System.out.println("Sum of " + value + " is " + submitSum.get());

        executorService.shutdown();
        System.out.println("Main thread pool completed");
    }
}

/*
Bu örnekte bir sayının factorial değerini ve birden o sayıya kadar olan sayıların
toplamını hesaplayan iki tane Callable taskı yarattık ve bu taskları bir executor
 service aracılığı ile çalıştırdık. Main threadin future objeleri üzerinden get()
  metodunu çağırdığında nasıl bloklandığını görmek için ise callable tasklarını
  çalıştıran threadlerin sleep() metodu yardımıyla üçer saniye uyumasını sağladık.
  Böylece executor service,
 callable ve future kavramlarının nasıl kullanıldığını görmüş olduk.
 */
