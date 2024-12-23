package com.github.heliannuuthus.hashtable;

import java.util.Arrays;

public class D8Intersect2 {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new Solution().intersect(new int[] {1, 2, 2, 1}, new int[] {2, 2})));
    }

    private static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            int[] numSet1 = new int[1001];
            int[] numSet2 = new int[1001];
            int[] res = new int[Math.min(nums1.length, nums2.length)];
            for (int i : nums1) {
                numSet1[i]++;
            }

            for (int i : nums2) {
                numSet2[i]++;
            }

            int idx = 0;

            for (int i = 0; i < numSet1.length; i++) {
                if (numSet1[i] > 0 && numSet2[i] > 0) {
                    for (int count = 0; count < Math.min(numSet1[i], numSet2[i]); count++) {
                        res[idx++] = i;
                    }
                }
            }
            return Arrays.copyOf(res, idx);
        }
    }
}
