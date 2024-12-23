package com.github.heliannuuthus.greedy;

public class D23Candy {

    public static void main(String[] args) {
        System.out.println(new Solution().candy(new int[] {1, 0, 2}));
    }

    private static class Solution {
        public int candy(int[] ratings) {
            int[] candies = new int[ratings.length];
            candies[0] = 1;

            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                } else {
                    candies[i] = 1;
                }
            }

            int sum = candies[ratings.length - 1];
            for (int i = ratings.length - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    candies[i] = Math.max(candies[i], candies[i + 1] + 1);
                }
                sum += candies[i];
            }
            return sum;
        }
    }
}
