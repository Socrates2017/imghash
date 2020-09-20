package com.zrzhen.imghash.core;

public class HammingDistanceUtil {

    /**
     * 汉明距离
     */
    public static int hammingDistance(String s1, String s2) {
        int counter = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                counter++;
            }
        }
        return counter;
    }
}
