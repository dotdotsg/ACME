/* (C)2025 */
package com.core.acme.utils;

import java.security.SecureRandom;

public class CustomIdUtil {
    private static final SecureRandom ran = new SecureRandom();

    private CustomIdUtil() {
        throw new IllegalStateException(Constants.UTILITY_CLASS_ERROR_MESSAGE);
    }

    public static String getCustomID(int length) {
        StringBuilder sb = new StringBuilder();
        String mask = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for (int i = length; i > 0; --i) sb.append(mask.charAt(ran.nextInt(mask.length())));
        return sb.toString();
    }
}
