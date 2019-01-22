package org.itstep;

import java.util.Random;

public class InputThread extends Thread {
    private Object locker;

    public InputThread(Object locker) {
        this.locker = locker;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (locker) {
                String rand = String.valueOf(
                    (new Random()).nextInt(10000)
                );
                WaitThreads.line = rand;
                System.out.println(
                    "Прочитал строку " + rand
                );

                locker.notify();
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
