package com.github.heliannuuthus.arrays;

import java.util.Scanner;

public class D5SumOfIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int length = scanner.nextInt();
        int[] arr = new int[length];
        int[] sums = new int[length + 1];
        sums[0] = 0;
        sums[1] = arr[0];
        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
            sums[i + 1] = sums[i] + arr[i];
        }
        while (scanner.hasNextInt()) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            System.out.println(sums[right + 1] - sums[left]);
        }
        scanner.close();
    }

}
