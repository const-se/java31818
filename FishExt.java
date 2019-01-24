package org.itstep;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class FishExt implements Externalizable {
    public String name = "";
    public transient int weight = 0;
    public int price = 0;


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(price * 100);
        out.writeObject(name);
        out.writeInt(weight);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        price = in.readInt() / 100;
        name = (String) in.readObject();
        weight = in.readInt();
    }

    @Override
    public String toString() {
        return name + ": " + weight + " кг по " + price + " рэ";
    }
}
