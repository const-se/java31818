package org.itstep;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        Thread3 t3 = new Thread3();

        delayedStart(t1);
        delayedStart(t2);
        delayedStart(t3);
    }

    // Отложенный старт потока
    private static void delayedStart(Thread thread) throws InterruptedException {
        // Пытаемся найти аннотацию Delay у класса потока
        Delay d = thread.getClass().getAnnotation(Delay.class);

        // Если аннотация есть, то делаем задержку старта
        if (null != d) {
            Thread.sleep(d.value());
        }

        thread.start();
    }

    @MyAnnotation(value = "hello", file = "C:\\Users\\Student\\1.txt")
    public static void example(
        @MyAnnotation(value = "!!!", targets = {@Target(ElementType.METHOD), @Target(ElementType.FIELD)}) String[] args
    ) {
        @MyAnnotation("Не трогать!")
        Method[] methods = Main.class.getMethods();

        for (Method m : methods) {
//            System.out.println(m);
//            Annotation[] annotations = m.getAnnotations();

//            for (Annotation a : annotations) {
//                System.out.println(m.getName() + ": " + a);
//            }
//            MyAnnotation myA = m.getAnnotation(MyAnnotation.class);

//            if (null != myA) {
//                System.out.println(myA.file());
//            }
            Parameter[] parameters = m.getParameters();

            for (Parameter p : parameters) {
                MyAnnotation myA = p.getAnnotation(MyAnnotation.class);

                if (myA != null) {
                    System.out.println(
                        m.getName() + ": " + p.getName() + ": " + myA.value()
                    );
                }
            }
        }
    }

    public void some() {
        System.out.println("!!!");
    }
}
