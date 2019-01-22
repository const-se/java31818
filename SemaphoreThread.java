package org.itstep;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaphoreThread extends Thread {
    public static Semaphore semaphore = new Semaphore(5);

    @Override
    public void run() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(
                5000 + (new Random()).nextInt(3000)
            );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(
            Thread.currentThread().getName()
                + "запустился"
        );

        semaphore.release();
    }
}
