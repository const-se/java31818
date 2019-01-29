package org.itstep;

import java.util.ArrayList;

public class Philosophers {
    private static final int COUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Fork> forks = new ArrayList<>();

        // Наполняем массив вилок
        for (int i = 0; i < COUNT; i++) {
            forks.add(new Fork());
        }

        ArrayList<Thread> threads = new ArrayList<>();

        // Наполняем массив потоков с философами
        for (int i = 0; i < COUNT; i++) {
            // Создаем философа
            // (i + 1) % COUNT - остаток от деления, для последнего
            // философа в правую руку будет помещена "первая" вилка
            Philosopher philosopher =
                new Philosopher(forks.get(i), forks.get((i + 1) % COUNT));

            // Создаем поток
            Thread thread = new Thread(philosopher, "Философ-" + (i + 1));
            // Добавляем "философский" поток в массив потоков
            threads.add(thread);
            thread.start();
        }

        for (int i = 0; i < COUNT; i++) {
            threads.get(i).join();
        }
    }
}
