package com.github.heliannuuthus.hashtable;

import java.util.*;

public class D8GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(new Solution().groupAnagrams(new String[] {"", "", "v"}));
    }

    private static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> charsets = new HashMap<>();
            for (String str : strs) {
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                charsets.compute(
                        String.valueOf(charArray),
                        (k, v) -> {
                            List<String> charset = Optional.ofNullable(v).orElse(new ArrayList<>());
                            charset.add(str);
                            return charset;
                        });
            }
            return new ArrayList<>(charsets.values());
        }
    }
}
