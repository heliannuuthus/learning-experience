package com.github.heliannuuthus.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class D22MaximizeSumOfArrayAfterKNegations {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSumAfterKNegations(new int[] {4, 2, 3}, 1));
    }

    private static class Solution {

        public int maxSumAfterKNegations(int[] nums, int k) {
            int[] array =
                    Arrays.stream(nums)
                            .boxed()
                            .sorted(Comparator.comparingInt(Math::abs))
                            .mapToInt(Integer::intValue)
                            .toArray();
            for (int i = nums.length - 1; i >= 0; i--) {
                if (array[i] < 0 && k > 0) {
                    array[i] = -array[i];
                    k--;
                }
            }
            k %= 2;
            while (k > 0) {
                array[0] = -array[0];
                k--;
            }
            return Arrays.stream(array).sum();
        }
    }
}
