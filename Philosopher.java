package org.itstep;

import java.util.Random;

public class Philosopher implements Runnable {
    private static final int MAX_FULLNESS = 5;

    private Fork leftFork;
    private Fork rightFork;
    private Random random = new Random();

    public Philosopher(Fork leftFork, Fork rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
//        int sec;

        message("Сел за стол");
        int fullness = 0;

        // Пока не наедисмя
        while (fullness < MAX_FULLNESS) {
            message("Берет левую вилку");

            // Пытаемся взять левую вилку, если не получается, начинаем все заново
            if (!leftFork.take()) {
                pause(5, "Левая вилка занята. Размышляет");
//                sec = random.nextInt(4) + 1;
//                message("Левая вилка занята. Размышляет " + sec + " с");
//                pause(sec);

                continue;
            }

            // Взяли левую вилку, пытаемся взять правую
            message("Берет правую вилку");
            boolean rightForkTaken = false;

            // Всего две попытки на взятие правой вилки
            for (int i = 0; i < 2; i++) {
                if (!rightFork.take()) {
                    // Не получилось взять правую вилку, размышляем
                    pause(5, "Правая вилка занята. Размышляет");
//                    sec = random.nextInt(4) + 1;
//                    message("Правая вилка занята. Размышляет " + sec + " с");
//                    pause(sec);
                } else {
                    // Правая вилка взята, идем дальше
                    rightForkTaken = true;
                    break;
                }
            }

            if (!rightForkTaken) {
                // На текущий момент правая вилка не взята, тогда кладем назад левую
                leftFork.put();
                // Обязательно размышляем, чтобы дать шанс соседу слева
                // взять освободившуюся вилку
                pause(5, "Положил левую вилку на стол. Размышляет");
//                sec = random.nextInt(4) + 1;
//                message("Положил левую вилку на стол. Размышляет " + sec + " с");
//                pause(sec);
                continue;
            }

            // Обе вилки взяты, можем есть
            pause(10, "Ест спагетти " + (fullness + 1) + " раз");
//            sec = random.nextInt(9) + 1;
//            message("Ест спагетти " + sec + " с");
//            pause(sec);
            // Увеличиваем сытость
            fullness++;

            // Кладем обе вилки на стол
            rightFork.put();
            leftFork.put();
            pause(5, "Закончил есть. Положил обе вилки. Размышляет");
//            sec = random.nextInt(4) + 1;
//            message("Закончил есть. Положил обе вилки и размышляет " + sec + " с");
//            pause(sec);
        }

        message("Нажрался и ушел");
    }

//    private void pause(int sec) {
//        try {
//            Thread.sleep(sec * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    private void pause(int maxSec, String message) {
        int sec = random.nextInt(maxSec - 1) + 1;
        message(message + " " + sec + " с");

        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void message(String message) {
        System.out.println(
            Thread.currentThread().getName()
                + ": " + message
        );
    }

}
