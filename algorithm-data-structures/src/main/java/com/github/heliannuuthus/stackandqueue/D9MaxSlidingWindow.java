package com.github.heliannuuthus.stackandqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class D9MaxSlidingWindow {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new Solution().maxSlidingWindow(new int[] {1, 3, 1, 2, 0, 5}, 3)));
    }

    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] result = new int[nums.length - k + 1];
            Deque<Integer> monotonousQueue = new ArrayDeque<>();
            int idx = 0;
            while (idx < nums.length) {
                if (monotonousQueue.isEmpty()) {
                    monotonousQueue.addLast(nums[idx]);
                } else {
                    while (!monotonousQueue.isEmpty() && monotonousQueue.peekLast() < nums[idx])
                        monotonousQueue.pollLast();

                    monotonousQueue.addLast(nums[idx]);
                }
                if (idx >= k - 1) {
                    result[idx - k + 1] = monotonousQueue.peekFirst();
                    if (monotonousQueue.peekFirst() == nums[idx - k + 1]) {
                        monotonousQueue.pollFirst();
                    }
                }

                idx++;
            }
            return result;
        }
    }
}
