package org.itstep;

@Delay(10000)
public class Thread2 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread2");
    }
}
