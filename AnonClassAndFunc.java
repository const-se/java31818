package org.itstep;

import java.util.ArrayList;

public class AnonClassAndFunc {

    public static String mainEncode(AbstractPasswordEncoder encoder, String password) {
        return encoder.encode(password);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(mainEncode(
                // Используем анонимный класс
                new AbstractPasswordEncoder() {
                    @Override
                    public String encode(String plainPassword) {
                        return plainPassword;
                    }

                    // Расширили абстрактный класс (но зачем?!)
                    public void print(String password) {
                        System.out.println(encode(password));
                    }
                },
                "123"
        ));
        System.out.println(
            mainEncode(
                // AbstractPasswordEncoder encoder
                // Анонимная функция (лямбда-выражение)
                (String plainPassword) -> {
                    return plainPassword + "!!!";
                },
                // String password
                "123"
            )
        );

        SomeInterface f = (String plainPassword) -> {
            return plainPassword + "!!!";
        };
//        mainEncode(f, "123"); Вызовет ошибку, несовместимость типов

// Краткие записи лямбд:

        // Фигурные скобки можно опустить
        SomeInterface a = (String password) -> password + "!!!";

        // Функция без аргументов, которая ничего не возвращает (void)
        SomeInterface2 b = () -> {
            int c = 10;
            System.out.println(c);
        };

        // Тип аргумента можно опустить, он будет определен впоследствии
//        SomeInterface si = (password) -> password;
        // Если аргумент один, и он без типа, то скобки тоже можно опустить
        SomeInterface si = password -> password;

        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(10);
        ints.add(5);
        ints.add(6);
        ints.add(4);

        // Использование лямбд для сортировок
        ints.sort((Integer a1, Integer a2) -> {
            if (a1 > a2) {
                return -1;
            }
            if (a1 < a2) {
                return 1;
            }
            return 0;
//            return a2 - a1;
        });
        System.out.println(ints);
//        ints.sort(Comparator.naturalOrder());
//        System.out.println(ints);

//        Runnable thread = () -> {
//            for (int i = 0; i < 10; i++) {
//                System.out.print(".");
//            }
//        };
//        Thread thread1 = new Thread(thread);
        Thread thread1 = new Thread(
            () -> {
                try {
                    Thread.sleep(3000);
                    // Обязательно в try..cactch (checked)
                    throw new InterruptedException();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 10; i++) {
                    System.out.print(".");
                }

                // Можно не обрабатывать (unchecked)
                throw new RuntimeException();
            }
        );
        thread1.start();
        thread1.join();

        // Анонимная функция - ссылка на реальный метод класса
        MainInterface mi = AnonClassAndFunc::main;
        // Рекурсия :)
//        mi.main(args);
    }
}
















