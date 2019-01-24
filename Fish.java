package org.itstep;

import java.io.Serializable;

public class Fish implements Serializable {
    public String name = "";
    public transient int weight = 0;
    public int price = 0;
    public transient String temporary = "123";

    @Override
    public String toString() {
        return name + ": " + weight + " кг по " + price + " рэ";
    }
}
