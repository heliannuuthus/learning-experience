package com.github.heliannuuthus.greedy;

public class D24LemonadeChange {
    public static void main(String[] args) {
        System.out.println(new Solution().lemonadeChange(new int[] {5, 5, 10, 10, 20}));
    }

    private static class Solution {
        public boolean lemonadeChange(int[] bills) {
            int[] cash = new int[3];
            for (int bill : bills) {
                if (bill / 5 == 1) {
                    cash[0]++;
                } else if (bill / 5 == 2) {
                    if (cash[0] >= 1) {
                        cash[1]++;
                        cash[0]--;
                    } else {
                        return false;
                    }
                } else {
                    if (cash[1] >= 1 && cash[0] >= 1) {
                        cash[1]--;
                        cash[0]--;
                    } else if (cash[0] >= 3) {
                        cash[0] -= 3;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
