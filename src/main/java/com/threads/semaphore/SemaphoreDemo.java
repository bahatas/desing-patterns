package com.threads.semaphore;

import com.threads.ShareObject;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo implements Runnable {

    private boolean increment;
    private String name;
    private Semaphore semaphore;

    public SemaphoreDemo(boolean increment, String name, Semaphore semaphore) {
        this.increment = increment;
        this.name = name;
        this.semaphore = semaphore;
    }


    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {


        try {
            semaphore.acquire();
            if (increment) {
                for (int i = 0; i < 5; i++) {
                    System.out.println(name + "value :" + ShareObject.incrementAndGet() + " "+Thread.currentThread().getName());
                    Thread.sleep(10);
                }
            } else {
                for (int i = 0; i < 5; i++) {
                    System.out.println(name + "value :" + ShareObject.decrementAndGet());
                    Thread.sleep(10);
                }
            }
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
        semaphore.release();
    }

}
/**
 * Bu örnekte semaphor objesini yaratırken constructora ilk erişim sayısını 1 olarak verdiğimize dikkat edelim.
 * Burada parametre olarak 1 değil de 0 verseydik bu durumda iki thread birden birbirini beklemeye başlayacaktı,
 * çünkü semaphore’un permit sayısı 0 olduğu zaman erişim yetkisini vermek için bir threadin release() metodunu
 * çağırmasını gerekir. Eğer erişim sayısını 1den daha büyük bir değer verseydik bu durumda da iki thread
 * birden aynı anda çalışacak ve paylaşılan objeye erişimi istediğimiz gibi engelleyemeyecektik.
 * Bu nedenle semaphore objesini yaratırken bu durumları göz önünde bulundurmak gerekir.
 */
