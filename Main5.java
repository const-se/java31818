package org.itstep;

import java.util.ArrayList;
import java.util.Random;

public class Main5 {

    static class Member {
        int number;
        Member next;

        Member(int number) {
            this.number = number + 1;
        }
    }

    public static void main(String[] args) {
        ArrayList<Member> list = generate();

        for (Member member : list) {
            System.out.println(member.number + " => " + member.next.number);
        }
    }

    public static ArrayList<Member> generate() {
        ArrayList<Member> list = new ArrayList<>();
        int i;

        for (i = 0; i < 100; i++) {
            list.add(new Member(i));
        }

        ArrayList<Member> cycle = new ArrayList<>();
        Random random = new Random();

        for (i = 0; i < 100; i++) {
            int j = random.nextInt(list.size());
            Member member = list.get(j);
            cycle.add(member);
            list.remove(j);

            if (i > 0) {
                cycle.get(i - 1).next = member;
            }
        }

        cycle.get(99).next = cycle.get(0);

        return cycle;
    }
}
