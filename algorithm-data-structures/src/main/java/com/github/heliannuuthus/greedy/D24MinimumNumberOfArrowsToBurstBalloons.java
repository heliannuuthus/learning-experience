package com.github.heliannuuthus.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class D24MinimumNumberOfArrowsToBurstBalloons {

    public static void main(String[] args) {
        System.out.println(
                new Solution().findMinArrowShots(new int[][] {{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
    }

    private static class Solution {
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
            int result = 1;
            for (int i = 1; i < points.length; i++) {
                if (points[i][0] <= points[i - 1][1]) {
                    points[i][1] = Math.min(points[i][1], points[i - 1][1]);
                } else {
                    result++;
                }
            }
            return result;
        }
    }
}
