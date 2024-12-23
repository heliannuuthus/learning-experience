package com.github.heliannuuthus.stackandqueue;

import java.util.*;

public class D9TopKFrequent {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new Solution().topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2)));
    }

    private static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> heap = new HashMap<>();
            for (int num : nums) {
                heap.compute(num, (key, val) -> val == null ? 1 : val + 1);
            }

            Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
            for (Map.Entry<Integer, Integer> entry : heap.entrySet()) {
                queue.add(new int[] {entry.getKey(), entry.getValue()});
            }
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = queue.poll()[0];
            }
            return result;
        }
    }
}
