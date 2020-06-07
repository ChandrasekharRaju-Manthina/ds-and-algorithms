package com.algorithms.other;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

    public static List<String> getPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        return getPermutations(new StringBuilder(str), 0, permutations);
    }

    private static List<String> getPermutations(StringBuilder sb, int index, List<String> permutations) {
        if(index == sb.length() - 1) {
            permutations.add(sb.toString());
        } else  {
            for (int i = index; i < sb.length(); i++) {
                swap(sb, i, index);
                getPermutations(sb, index + 1, permutations);
                swap(sb, i, index);
            }
        }
        return permutations;
    }

    private static void swap(StringBuilder sb, int i, int index) {
        char temp = sb.charAt(index);
        sb.setCharAt(index, sb.charAt(i));
        sb.setCharAt(i, temp);
    }

}
