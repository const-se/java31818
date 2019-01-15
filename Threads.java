package org.itstep;

public class Threads {
    public static void main(String[] args) throws InterruptedException {
        Thread1 t1 = new Thread1(400000);
        Thread1 t2 = new Thread1(400000);
//        Thread2 t3 = new Thread2();
        t1.setName("Кай");
        t2.setName("Герда");

//        Thread t4 = new Thread(t3);
//        t4.start();
////        (new Thread(t3)).start();
        t1.start();
        t2.start();

        Thread.sleep(100);
        t1.interrupt();
        t2.interrupt();

//        ЛУЧШЕ ТАК НЕ ДЕЛАТЬ!
//        while (t1.isAlive() || t2.isAlive()) {
//            System.out.println("!");
//        }
//
//        ТАК ДЕЛАТЬ ТОЧНО НЕЛЬЗЯ!!!
//        try {
//            Thread.sleep(10000);
//        } catch (Exception e) {
//        }

        t1.join();
        t2.join();

        System.out.println("Вот и всё");
    }
}
