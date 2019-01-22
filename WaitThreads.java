package org.itstep;

public class WaitThreads {
    public static String line = "";

    public static void main(String[] args) {
        Object locker = new Object();
        OutputThread output = new OutputThread(locker);
        InputThread input = new InputThread(locker);

        output.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        input.start();

        try {
            input.join();
            output.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
