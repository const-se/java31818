package org.itstep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Consumer;

public class Main8 {
    static class Student {
        public int index;
//        public int oldHash;

        public Student(int i) {
            index = i;
        }

        @Override
        public int hashCode() {
//            oldHash = super.hashCode();
            return index;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Student) {
                return index == ((Student) obj).index;
            }

            return false;
        }

        //        @Override
//        public String toString() {
//            return String.valueOf(index);
//        }
    }

    public static void main(String[] args) {
        Student a = new Student(0);

        Consumer<Student> c = (Student e) -> {
            e.index = 123;
        };

        c.accept(a);
        System.out.println(a.index);
    }

    public static void iteratorExample() {
        ArrayList<Student> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(new Student(i));
        }

        Iterator<Student> iter = list.iterator();

        while (iter.hasNext()) {
            Student s = iter.next();

            if (s.index == 5) {
                iter.remove();
                continue;
            }

            System.out.println(s);
        }

        System.out.println(list);

        // Неправильно!
//        for (int i = 0; i < 10; i++) {
//            if (i == 5) {
//                list.remove(5);
//                continue;
//            }
//
//            System.out.println(list.get(i));
//        }

//        for (Student s : list) {
//            s.index++;
//        }

        Consumer<Student> cons = (Student s) -> {
            // some code...
            s.index++;
            // some code...
        };

        Consumer<Student> cons2 = (Student s) -> {
            s.index += 10;
        };

        list.forEach(cons2);
        list.forEach(Main8::apply);

        System.out.println(list);
    }

    public static void apply(Student s) {
        s.index++;
    }

    public static void mapExample() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("second", new Student(1));
        map.put("first", new Student(0));
        map.put("third", new ArrayList<String>());
        map.size();

        System.out.println(map);
        System.out.println(map.get("second"));
    }

    public static void setExample() {
        HashSet<Student> set = new HashSet<>();

        Student student = new Student(2);
        set.add(student);
        set.add(student);
        set.add(new Student(2));

        ArrayList<Student> list = new ArrayList<>();
        list.add(student);
        list.add(student);
        list.add(student);

        System.out.println(set);
        System.out.println(list);
    }

    public static void listExample() {
        ArrayList<Student> list = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            list.add(new Student(i));
        }

        System.out.println(list);
        System.out.println(list.get(2));

        for (int i = 0; i < 8; i++) {
            if (i == 5) {
                list.remove(5);
            }

            System.out.println(list.get(i));
        }

        for (Student s : list) {
            System.out.println(s);
        }

        Iterator<Student> iter = list.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        ArrayList<Student> list2 = new ArrayList<>();

        for (int j = 0; j < 3; j++) {
            list2.add(iter.next());
        }
    }
}
