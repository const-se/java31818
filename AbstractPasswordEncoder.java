package org.itstep;

/*abstract public class AbstractPasswordEncoder {
//    public String encode(String plainPassword) {
//        plainPassword += "salt";
//
//        return  plainPassword;
//    }
    abstract public String encode(String plainPassword);
}*/

public interface AbstractPasswordEncoder {
    String encode(String plainPassword);
}
