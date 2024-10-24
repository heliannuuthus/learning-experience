package com.github.heliannuuthus.string;

import java.util.Scanner;

public class D9TurnRightStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int k = scanner.nextInt();
        while (scanner.hasNext()) {
            String charsets = scanner.nextLine();
            if (charsets.isEmpty()) {
                continue;
            }
            char[] chars = charsets.toCharArray();
            if (chars.length < k) {
                System.out.println(new String(chars));
                return;
            }

            // 原地
            for (int i = 1; i <= k; i++) {
                char temp = chars[chars.length - 1];
                for (int curr = chars.length - 1, prev = chars.length - 2;
                        prev >= 0;
                        curr--, prev--) {
                    chars[curr] = chars[prev];
                }
                chars[0] = temp;
            }
            System.out.println(new String(chars));
            return;
        }
    }
}
