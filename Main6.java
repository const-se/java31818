package org.itstep;

import java.util.ArrayList;

public class Main6 {
    public static void main(String[] args) {
        int a = 10;
        int c = 0;
        int b = 123;
        ArrayList<Integer> str = null;

        // .........................................................

        try {
            try {
                b = a / 0;
                str.add(b);
            } catch (NullPointerException exc) {
                System.out.println("NULL!!!");
            } finally {
                b = 0;
            }

            str.add(b);
            System.out.println(b);
        } catch (ArithmeticException e) {
            System.out.println("Мы здесь!");
        }

        System.out.println(b);
    }
}
