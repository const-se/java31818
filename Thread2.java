package org.itstep;

public class Thread2 extends SomeClass implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("!");
        }
    }
}
