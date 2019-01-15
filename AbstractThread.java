package org.itstep;

public class AbstractThread extends Thread {
    private int value;

    public AbstractThread(int v) {
        value = v;
    }

    @Override
    public void run() {
        System.out.println(
            "Поток " + Thread.currentThread().getName()
                + " начал работу со значением "
                + value
        );

//        try {
//            Thread.sleep(250);
//        } catch (Exception e) {
//        }

        while (value >= 0 && !this.isInterrupted()) {
            System.out.println(
                "Поток " + Thread.currentThread().getName()
                    + ": value = " + value
            );
            value--;

//            try {
//                Thread.sleep(250);
//            } catch (Exception e) {
//            }
        }

        System.out.println(
            "Поток " + Thread.currentThread().getName()
                + " завершил свою работу"
                + " со значением " + value
        );
    }
}
