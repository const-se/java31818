package org.itstep;

public class IncThread extends Thread {
    private Integer limit;

    public IncThread(Integer limit) {
        this.limit = limit;
    }

    @Override
    public void run() {
        for (Integer i = 0; i < limit; i++) {
//            synchronized (SyncThreads.locker) {
//                ++SyncThreads.counter;
//            }
            SyncThreads.add(1);
        }

        System.out.println(
            Thread.currentThread().getName()
                + " завершил работу"
        );
    }
}
