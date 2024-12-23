package com.github.heliannuuthus.greedy;

public class D23GasStation {

    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .canCompleteCircuit(new int[] {5, 1, 2, 3, 4}, new int[] {4, 4, 1, 5, 1}));
    }

    private static class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int[] rest = new int[gas.length];
            for (int i = 0; i < gas.length; i++) {
                rest[i] = gas[i] - cost[i];
            }

            int sum = 0, idx = 0, min = Integer.MAX_VALUE;
            for (int i = 0; i < rest.length; i++) {
                sum += rest[i];
                if (sum < min) {
                    idx = (i + 1) % (gas.length);
                    min = sum;
                }
            }
            return sum >= 0 ? idx : -1;
        }
    }
}
