package com.github.heliannuuthus.greedy;

import java.util.*;

public class D24QueueReconstructionByHeight {

    public static void main(String[] args) {
        System.out.println(
                Arrays.deepToString(
                        new Solution()
                                .reconstructQueue(
                                        new int[][] {
                                            {9, 0}, {7, 0}, {1, 9}, {3, 0}, {2, 7}, {5, 3}, {6, 0},
                                            {3, 4}, {6, 2}, {5, 2}
                                        })));
    }

    private static class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(
                    people,
                    (o1, o2) -> {
                        if (o1[0] != o2[0]) {
                            return o2[0] - o1[0];
                        } else {
                            return o1[1] - o2[1];
                        }
                    });
            List<int[]> queue = new LinkedList<>();
            for (int[] person : people) {
                if (queue.isEmpty() || queue.size() <= person[1]) {
                    queue.add(person[1], person);
                } else {
                    int[] curr = queue.get(person[1]);
                    if (Objects.nonNull(curr)) {
                        if (person[0] < curr[0]) {
                            queue.add(person[1], person);
                        } else {
                            queue.add(person[1] + 1, person);
                        }
                    } else {
                        queue.add(person[1], person);
                    }
                }
            }
            return queue.toArray(new int[queue.size()][]);
        }
    }
}
