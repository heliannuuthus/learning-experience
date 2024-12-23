package com.github.heliannuuthus.backtrack;

import java.util.*;

public class D18FindSubsequences {
    public static void main(String[] args) {

        List<List<Integer>> subsequences =
                new Solution()
                        .findSubsequences(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 1, 1});
        System.out.println(subsequences.size());
        System.out.println(new HashSet<>(subsequences).size());
    }

    public static <T> List<T> findDuplicates(List<T> list) {
        Set<T> seen = new HashSet<>();
        Set<T> duplicates = new HashSet<>();

        for (T element : list) {
            if (!seen.add(element)) { // 如果无法添加到 seen 中，说明重复
                duplicates.add(element);
            }
        }

        return new ArrayList<>(duplicates); // 转换为 List 返回
    }

    private static class Solution {

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> findSubsequences(int[] nums) {
            backtrack(nums, 0);
            return result;
        }

        private void backtrack(int[] nums, int start) {
            if (path.size() > 1) {
                result.add(new ArrayList<>(path));
            }

            HashSet<Integer> unrepeatable = new HashSet<>();

            for (int i = start; i < nums.length; i++) {
                if (!path.isEmpty() && path.peekLast() > nums[i]
                        || unrepeatable.contains(nums[i])) {
                    continue;
                }
                unrepeatable.add(nums[i]);
                path.addLast(nums[i]);
                backtrack(nums, i + 1);
                path.removeLast();
            }
        }
    }
}
