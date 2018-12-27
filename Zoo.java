package org.itstep;

import java.util.Scanner;

public class Zoo {
    private static Scanner scanner;

    public static void main(String[] args) {
        Boolean gameOver = false;
        Node root = getDefaultTree();

        while (!gameOver) {
            round(root);

            gameOver = !continueGame();
        }

        System.out.println("До свидания!");
    }

    private static boolean continueGame() {
        return question("Сыграть еще раз?");
    }

    private static Scanner getScanner() {
        if (null == scanner) {
            scanner = new Scanner(System.in);
        }

        return scanner;
    }

    private static Node getDefaultTree() {
        Leaf positive = new Leaf("Свинья");
        Leaf negative = new Leaf("Лошадь");
        Node root = new Node("Оно хрюкает?", positive, negative);

        return root;
    }

    private static void round(Node root) {
        TreeNode current = root;
        Node previous = root;
        boolean previousAnswer = true;

        while (current instanceof Node) {
            previous = (Node) current;

            if (question(((Node) current).getQuestion())) {
                previousAnswer = true;
                current = ((Node) current).getPositive();
            } else {
                previousAnswer = false;
                current = ((Node) current).getNegative();
            }
//            current = question(((Node) current).getQuestion())
//                ? ((Node) current).getPositive()
//                : ((Node) current).getNegative();
//----------------------------------------------------------------
//            System.out.println(((Node) current).getQuestion());
//            answer = getScanner().nextLine();
//
//            if (answer.toLowerCase().equals("да")) {
//                current = ((Node) current).getPositive();
//            } else {
//                current = ((Node) current).getNegative();
//            }
        }

        if (question("Это " + ((Leaf) current).getAnimal() + "?")) {
            System.out.println("Ура! Я угадал!");
        } else {
            System.out.println("А что вы загадали?");
            String animal = getScanner().nextLine();
            Leaf newAnimal = new Leaf(animal);

            System.out.println("А как отличить ваше животное?");
            String question = getScanner().nextLine();

            Node newQuestion = new Node(question, newAnimal, current);

            if (previousAnswer) {
                previous.setPositive(newQuestion);
            } else {
                previous.setNegative(newQuestion);
            }
        }
    }

    private static boolean question(String question) {
        System.out.println(question + " [да/нет] ");
        String answer = getScanner().nextLine();

        return answer.toLowerCase().equals("да");
    }
}
