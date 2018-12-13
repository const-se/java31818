package org.itstep;

public class Main2 {
    interface S {
        String b = "123123";
        int s();
    }

    interface AngleCountable {
        int countAngles();
    }

    interface SuperShape extends S, AngleCountable {
    }

    abstract class Shape implements S {
        public static final String str = "!!!";

        public abstract int s();
    }

    class Square extends Shape implements AngleCountable, S {
        int a;

        public int s() {
            return a * a;
        }

        public final int countAngles() {
            String a = this.str;
            return 4;
        }
    }

    class Rectangle extends Square {
        int b;

        @Override
        public int s() {
            return a * b;
        }
    }

    final class Circle extends Shape {
        int r;

        public int s() {
            return 3/* Pi)) */ * r * r;
        }
    }

    public static void main(String[] args) {
    }

    public static int mainCountAngles(Shape a) {
        if (a instanceof AngleCountable) {
            ((AngleCountable)a).countAngles();
        }
        long c = 213;
        int b = (int)c + 1 + (int)Math.PI;

        return a.s();
    }
}
