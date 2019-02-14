package org.itstep;

public class PlainPasswordEncoder implements AbstractPasswordEncoder {
    @Override
    public String encode(String plainPassword) {
//        String password = super.mainEncode(plainPassword);

        return plainPassword;
    }
}
