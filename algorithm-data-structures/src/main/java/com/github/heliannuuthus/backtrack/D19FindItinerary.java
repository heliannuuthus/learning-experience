package com.github.heliannuuthus.backtrack;

import java.util.*;

public class D19FindItinerary {

    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .findItinerary(
                                List.of(
                                        List.of("JFK", "SFO"),
                                        List.of("JFK", "ATL"),
                                        List.of("SFO", "ATL"),
                                        List.of("ATL", "JFK"),
                                        List.of("ATL", "SFO"))));
    }

    private static class Solution {

        Map<String, Map<String, Integer>> path = new TreeMap<>(String::compareTo);

        List<String> result = new ArrayList<>();

        public List<String> findItinerary(List<List<String>> tickets) {

            for (List<String> ticket : tickets) {
                path.compute(
                        ticket.get(0),
                        (k, v) -> {
                            Map<String, Integer> tmp = Objects.isNull(v) ? new TreeMap<>() : v;
                            tmp.put(ticket.get(1), tmp.getOrDefault(ticket.get(1), 0) + 1);
                            return tmp;
                        });
            }
            result.add("JFK");
            backtrack(tickets);
            return result;
        }

        private boolean backtrack(List<List<String>> tickets) {
            if (result.size() == tickets.size() + 1) {
                return true;
            }

            Map<String, Integer> tmp = path.get(result.get(result.size() - 1));
            if (Objects.isNull(tmp)) {
                return false;
            }
            for (Map.Entry<String, Integer> tmpEntities : tmp.entrySet()) {
                if (tmpEntities.getValue() > 0) {
                    result.add(tmpEntities.getKey());
                    tmpEntities.setValue(tmpEntities.getValue() - 1);
                    if (backtrack(tickets)) {
                        return true;
                    }
                    tmpEntities.setValue(tmpEntities.getValue() + 1);
                    result.remove(result.size() - 1);
                }
            }
            return false;
        }
    }
}
