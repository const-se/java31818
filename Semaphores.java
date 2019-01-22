package org.itstep;

import java.util.ArrayList;

public class Semaphores {
    public static void main(String[] args) {
        ArrayList<SemaphoreThread> list = new ArrayList<>();
        SemaphoreThread thread;

        for (int i = 0; i < 100; i++) {
            thread = new SemaphoreThread();
            thread.start();
            list.add(thread);
        }

        for (SemaphoreThread thread1 : list) {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
