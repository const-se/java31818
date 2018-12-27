package org.itstep;

public class Node implements TreeNode {
    private String question;
    private TreeNode positive; // Узел или лист, ответ "Да"
    private TreeNode negative; // Узел или лист, ответ "Нет"

    public Node(String question, TreeNode positive, TreeNode negative) {
        this.question = question;
        this.positive = positive;
        this.negative = negative;
    }

    public String getQuestion() {
        return question;
    }

    public TreeNode getPositive() {
        return positive;
    }

    public TreeNode getNegative() {
        return negative;
    }

    public void setPositive(TreeNode positive) {
        this.positive = positive;
    }

    public void setNegative(TreeNode negative) {
        this.negative = negative;
    }
}
