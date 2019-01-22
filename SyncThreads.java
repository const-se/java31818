package org.itstep;

public class SyncThreads {
    public static Integer counter = 0;
    public final static Object locker = new Object();

    public static synchronized void add(Integer value) {
        counter += value;
    }

    public static void main(String[] args) {
        IncThread inc = new IncThread(1000);
//        inc.setName("INC");
        DecThread dec = new DecThread(1000);
//        dec.setName("DEC");

        inc.start();
        dec.start();

        try {
            inc.join();
            dec.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("counter=" + counter);
    }
}
