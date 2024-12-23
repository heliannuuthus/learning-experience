package com.github.heliannuuthus.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D25MergeIntervals {

    public static void main(String[] args) {
        System.out.println(
                Arrays.deepToString(
                        new Solution().merge(new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }

    private static class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return new int[][] {};
            }
            Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            List<int[]> mergedIntervals = new ArrayList<>();
            mergedIntervals.add(intervals[0]);
            for (int i = 1; i < intervals.length; i++) {
                int[] tmp = mergedIntervals.get(mergedIntervals.size() - 1);
                if (intervals[i][0] <= tmp[1]) {
                    intervals[i][0] = Math.min(intervals[i][0], tmp[0]);
                    intervals[i][1] = Math.max(intervals[i][1], tmp[1]);
                    mergedIntervals.set(mergedIntervals.size() - 1, intervals[i]);
                } else {
                    mergedIntervals.add(intervals[i]);
                }
            }
            return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
        }
    }
}
