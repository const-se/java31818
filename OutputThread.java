package org.itstep;

public class OutputThread extends Thread {
    private Object locker;

    public OutputThread(Object locker) {
        this.locker = locker;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (locker) {
                try {
                    locker.wait();
//                    locker.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(
                    "Записал строку " + WaitThreads.line
                );
                locker.notify();
            }
        }
    }
}
