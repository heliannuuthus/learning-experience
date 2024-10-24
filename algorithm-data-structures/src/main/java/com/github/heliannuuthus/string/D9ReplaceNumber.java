package com.github.heliannuuthus.string;

import java.util.Scanner;

public class D9ReplaceNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray(), numberChars = "number".toCharArray();
        int count = 0;
        for (char aChar : chars) {
            if (aChar >= '0' && aChar <= '9') count += numberChars.length;
            else count++;
        }
        int idx = count - 1;
        char[] result = new char[count];
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                for (int j = numberChars.length - 1; j >= 0; j--) {
                    result[idx--] = numberChars[j];
                }
            } else {
                result[idx--] = chars[i];
            }
        }
        System.out.println(new String(result));
    }
}
