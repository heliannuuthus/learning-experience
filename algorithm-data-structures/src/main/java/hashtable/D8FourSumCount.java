package hashtable;

import java.util.HashMap;
import java.util.Map;

public class D8FourSumCount {


    public static void main(String[] args) {
        System.out.println(new Solution().fourSumCount(new int[]{-1, 1}, new int[]{-1, -1}, new int[]{-1, 1}, new int[]{-1, 1}));
    }

    static class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            Map<Integer, Integer> firstSum = new HashMap<>();
            Map<Integer, Integer> secondSum = new HashMap<>();
            for (int item : nums1) {
                for (int i : nums2) {
                    firstSum.compute(-(item + i), (k, v) -> v == null ? 1 : v + 1);
                }
            }
            for (int j : nums3) {
                for (int value : nums4) {
                    secondSum.compute(j + value, (k, v) -> v == null ? 1 : v + 1);
                }
            }
            return firstSum.keySet().stream().filter(secondSum::containsKey).mapToInt(key -> firstSum.get(key) * secondSum.get(key)).sum();
        }
    }
}

