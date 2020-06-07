package com.algorithms.other;

class LevenshteinDistance {

    public static void main(String[] args) {
        System.out.println(LevenshteinDistance.editDistance("biting", "mitten"));
    }

    public static int editDistance(String str1, String str2) {

        int[][] edits = new int[str2.length() + 1][str1.length() + 1];

        for (int j = 0; j < edits[0].length; j++) {
            edits[0][j] = j;
        }

        for (int i = 1; i < edits.length; i++) {
            edits[i][0] = i;
        }

        for (int i = 1; i < edits.length; i++) {
            for (int j = 1; j < edits[i].length; j++) {
                if (str1.charAt(j - 1) == str2.charAt(i - 1)) {
                    edits[i][j] = edits[i - 1][j - 1];
                } else {
                    edits[i][j] = min(edits[i - 1][j - 1], edits[i][j - 1], edits[i - 1][j]) + 1;
                }
            }
        }

        return edits[str2.length()][str1.length()];
    }

    private static int min(int a, int b, int c) {
        if (a < b && a < c) {
            return a;
        }

        return Math.min(b, c);
    }

}
