package org.itstep;

@Delay(3000)
public class Thread1 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread1");
    }
}
