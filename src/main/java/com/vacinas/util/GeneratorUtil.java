package com.vacinas.util;

import java.security.SecureRandom;
import java.util.Random;

public class GeneratorUtil {
    static Random random = new SecureRandom();
    static final String OTP = "0123456789";
    static final String INPUT = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "abcdefghijklmnopqrstuvwxyz0123456789/*+.=_@-?";
    static final String CHAR_AT = "ABCDEFGHIJKLMNOPQRSTUVWXY";

    public char charAt() {
        return CHAR_AT.charAt(random.nextInt(CHAR_AT.length()));
    }


    public static String generateRandomOTP(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(OTP.charAt(random.nextInt(OTP.length())));
        }
        return builder.toString();
    }

    public static String generateRandomPassword(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(INPUT.charAt(random.nextInt(INPUT.length())));
        }
        return builder.toString();
    }

    public String generateRandomStringWithSpecialChar(int length, int space, String especialChar) {
        StringBuilder builder = new StringBuilder();
        int index = 0;
        while (length > 0) {
            if (space == index) {
                builder.append(especialChar);
                index = 0;
            }
            length--;
            index++;
            builder.append(charAt());
        }
        return builder.toString();
    }


}
