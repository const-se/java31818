package org.itstep;

public class Leaf implements TreeNode {
    private String animal;

    public Leaf(String animal) {
        this.animal = animal;
    }

    public String getAnimal() {
        return animal;
    }
}
