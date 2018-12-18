package org.itstep;

public class Main7 {
    static class MyException extends Exception {
    }

    static class MySecondException extends RuntimeException {
    }

    public static void main(String[] args) throws Exception {
        example("12");
        System.out.println(example("123as"));
    }

    public static String example(String a) throws Exception {
        int b = 0;

        try {
            b = Integer.parseInt(a);
            b++;
        } catch (NumberFormatException e) {
            throw new Exception(e.getMessage());
        }

        return String.valueOf(b);
    }
}
