package com.algorithms.other;

public class KadanesAlgorithm {

    public static int maxSubArraySum(int[] array) {
        int maxSum = Integer.MIN_VALUE, sum = 0;
        for (int num : array) {
            sum = Math.max(sum + num, num);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

}
