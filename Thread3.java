package org.itstep;

// Аннотации предков не наследуются
public class Thread3 extends Thread2 {
    @Override
    public void run() {
        System.out.println("Thread3");
    }
}
